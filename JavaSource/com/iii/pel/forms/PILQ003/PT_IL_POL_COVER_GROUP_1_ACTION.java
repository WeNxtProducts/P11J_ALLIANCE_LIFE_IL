    package com.iii.pel.forms.PILQ003;
    
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
    
    public class PT_IL_POL_COVER_GROUP_1_ACTION extends CommonAction {
    
    	private HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL;
    
    	private HtmlInputText COMP_UI_M_PROD_CODE;
    
    	private HtmlOutputLabel COMP_PCG_CODE_LABEL;
    
    	private HtmlInputText COMP_PCG_CODE;
    
    	private HtmlOutputLabel COMP_PCG_RATE_LABEL;
    
    	private HtmlInputText COMP_PCG_RATE;
    
    	private HtmlOutputLabel COMP_PCG_RATE_PER_LABEL;
    
    	private HtmlInputText COMP_PCG_RATE_PER;
    
    	private HtmlOutputLabel COMP_PCG_FC_PREM_LABEL;
    
    	private HtmlInputText COMP_PCG_FC_PREM;
    
    	private HtmlOutputLabel COMP_PCG_LC_PREM_LABEL;
    
    	private HtmlInputText COMP_PCG_LC_PREM;
    
    	private HtmlOutputLabel COMP_UI_M_PCD_CODE_DESC_LABEL;
    
    	private HtmlInputText COMP_UI_M_PCD_CODE_DESC;
    
    	private HtmlOutputLabel COMP_PCG_ORG_FC_PREM_LABEL;
    
    	private HtmlInputText COMP_PCG_ORG_FC_PREM;
    
    	private HtmlOutputLabel COMP_PCG_ORG_LC_PREM_LABEL;
    
    	private HtmlInputText COMP_PCG_ORG_LC_PREM;
    
    	private HtmlCommandButton COMP_UI_M_BTN_COVER_DTLS;
    
    	private HtmlCommandButton COMP_UI_M_BTN_MAIN_PROD_1;
    
    	private HtmlCommandButton COMP_UI_M_COVERGROUP_LOV_BTN_1;
    
    	private PT_IL_POL_COVER_GROUP_1 PT_IL_POL_COVER_GROUP_1_BEAN;
    
    	public PILQ003_COMPOSITE_ACTION compositeAction;
    
    	private PT_IL_POL_COVER_GROUP_1_HELPER helper;
    
    	private List<PT_IL_POL_COVER_GROUP_1> dataList_PT_IL_POL_COVER_GROUP_1 = new ArrayList<PT_IL_POL_COVER_GROUP_1>();
    
    	 private UIData dataTable;
    
            
            
            public PT_IL_POL_COVER_GROUP_1_ACTION() {
    
        	PT_IL_POL_COVER_GROUP_1_BEAN = new PT_IL_POL_COVER_GROUP_1();
        	helper = new PT_IL_POL_COVER_GROUP_1_HELPER();
        	instantiateAllComponent();
            }
    
    	public HtmlOutputLabel getCOMP_UI_M_PROD_CODE_LABEL() {
    		return COMP_UI_M_PROD_CODE_LABEL;
    	}
    
    	public HtmlInputText getCOMP_UI_M_PROD_CODE() {
    		return COMP_UI_M_PROD_CODE;
    	}
    
    	public void setCOMP_UI_M_PROD_CODE_LABEL(HtmlOutputLabel COMP_UI_M_PROD_CODE_LABEL) {
    		this.COMP_UI_M_PROD_CODE_LABEL = COMP_UI_M_PROD_CODE_LABEL;
    	}
    
    	public void setCOMP_UI_M_PROD_CODE(HtmlInputText COMP_UI_M_PROD_CODE) {
    		this.COMP_UI_M_PROD_CODE = COMP_UI_M_PROD_CODE;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_CODE_LABEL() {
    		return COMP_PCG_CODE_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_CODE() {
    		return COMP_PCG_CODE;
    	}
    
    	public void setCOMP_PCG_CODE_LABEL(HtmlOutputLabel COMP_PCG_CODE_LABEL) {
    		this.COMP_PCG_CODE_LABEL = COMP_PCG_CODE_LABEL;
    	}
    
    	public void setCOMP_PCG_CODE(HtmlInputText COMP_PCG_CODE) {
    		this.COMP_PCG_CODE = COMP_PCG_CODE;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_RATE_LABEL() {
    		return COMP_PCG_RATE_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_RATE() {
    		return COMP_PCG_RATE;
    	}
    
    	public void setCOMP_PCG_RATE_LABEL(HtmlOutputLabel COMP_PCG_RATE_LABEL) {
    		this.COMP_PCG_RATE_LABEL = COMP_PCG_RATE_LABEL;
    	}
    
    	public void setCOMP_PCG_RATE(HtmlInputText COMP_PCG_RATE) {
    		this.COMP_PCG_RATE = COMP_PCG_RATE;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_RATE_PER_LABEL() {
    		return COMP_PCG_RATE_PER_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_RATE_PER() {
    		return COMP_PCG_RATE_PER;
    	}
    
    	public void setCOMP_PCG_RATE_PER_LABEL(HtmlOutputLabel COMP_PCG_RATE_PER_LABEL) {
    		this.COMP_PCG_RATE_PER_LABEL = COMP_PCG_RATE_PER_LABEL;
    	}
    
    	public void setCOMP_PCG_RATE_PER(HtmlInputText COMP_PCG_RATE_PER) {
    		this.COMP_PCG_RATE_PER = COMP_PCG_RATE_PER;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_FC_PREM_LABEL() {
    		return COMP_PCG_FC_PREM_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_FC_PREM() {
    		return COMP_PCG_FC_PREM;
    	}
    
    	public void setCOMP_PCG_FC_PREM_LABEL(HtmlOutputLabel COMP_PCG_FC_PREM_LABEL) {
    		this.COMP_PCG_FC_PREM_LABEL = COMP_PCG_FC_PREM_LABEL;
    	}
    
    	public void setCOMP_PCG_FC_PREM(HtmlInputText COMP_PCG_FC_PREM) {
    		this.COMP_PCG_FC_PREM = COMP_PCG_FC_PREM;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_LC_PREM_LABEL() {
    		return COMP_PCG_LC_PREM_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_LC_PREM() {
    		return COMP_PCG_LC_PREM;
    	}
    
    	public void setCOMP_PCG_LC_PREM_LABEL(HtmlOutputLabel COMP_PCG_LC_PREM_LABEL) {
    		this.COMP_PCG_LC_PREM_LABEL = COMP_PCG_LC_PREM_LABEL;
    	}
    
    	public void setCOMP_PCG_LC_PREM(HtmlInputText COMP_PCG_LC_PREM) {
    		this.COMP_PCG_LC_PREM = COMP_PCG_LC_PREM;
    	}
    
    	public HtmlOutputLabel getCOMP_UI_M_PCD_CODE_DESC_LABEL() {
    		return COMP_UI_M_PCD_CODE_DESC_LABEL;
    	}
    
    	public HtmlInputText getCOMP_UI_M_PCD_CODE_DESC() {
    		return COMP_UI_M_PCD_CODE_DESC;
    	}
    
    	public void setCOMP_UI_M_PCD_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PCD_CODE_DESC_LABEL) {
    		this.COMP_UI_M_PCD_CODE_DESC_LABEL = COMP_UI_M_PCD_CODE_DESC_LABEL;
    	}
    
    	public void setCOMP_UI_M_PCD_CODE_DESC(HtmlInputText COMP_UI_M_PCD_CODE_DESC) {
    		this.COMP_UI_M_PCD_CODE_DESC = COMP_UI_M_PCD_CODE_DESC;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_ORG_FC_PREM_LABEL() {
    		return COMP_PCG_ORG_FC_PREM_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_ORG_FC_PREM() {
    		return COMP_PCG_ORG_FC_PREM;
    	}
    
    	public void setCOMP_PCG_ORG_FC_PREM_LABEL(HtmlOutputLabel COMP_PCG_ORG_FC_PREM_LABEL) {
    		this.COMP_PCG_ORG_FC_PREM_LABEL = COMP_PCG_ORG_FC_PREM_LABEL;
    	}
    
    	public void setCOMP_PCG_ORG_FC_PREM(HtmlInputText COMP_PCG_ORG_FC_PREM) {
    		this.COMP_PCG_ORG_FC_PREM = COMP_PCG_ORG_FC_PREM;
    	}
    
    	public HtmlOutputLabel getCOMP_PCG_ORG_LC_PREM_LABEL() {
    		return COMP_PCG_ORG_LC_PREM_LABEL;
    	}
    
    	public HtmlInputText getCOMP_PCG_ORG_LC_PREM() {
    		return COMP_PCG_ORG_LC_PREM;
    	}
    
    	public void setCOMP_PCG_ORG_LC_PREM_LABEL(HtmlOutputLabel COMP_PCG_ORG_LC_PREM_LABEL) {
    		this.COMP_PCG_ORG_LC_PREM_LABEL = COMP_PCG_ORG_LC_PREM_LABEL;
    	}
    
    	public void setCOMP_PCG_ORG_LC_PREM(HtmlInputText COMP_PCG_ORG_LC_PREM) {
    		this.COMP_PCG_ORG_LC_PREM = COMP_PCG_ORG_LC_PREM;
    	}
    
    	public HtmlCommandButton getCOMP_UI_M_BTN_COVER_DTLS() {
    		return COMP_UI_M_BTN_COVER_DTLS;
    	}
    
    	public void setCOMP_UI_M_BTN_COVER_DTLS(HtmlCommandButton COMP_UI_M_BTN_COVER_DTLS) {
    		this.COMP_UI_M_BTN_COVER_DTLS = COMP_UI_M_BTN_COVER_DTLS;
    	}
    
    	public HtmlCommandButton getCOMP_UI_M_BTN_MAIN_PROD_1() {
    		return COMP_UI_M_BTN_MAIN_PROD_1;
    	}
    
    	public void setCOMP_UI_M_BTN_MAIN_PROD_1(HtmlCommandButton COMP_UI_M_BTN_MAIN_PROD_1) {
    		this.COMP_UI_M_BTN_MAIN_PROD_1 = COMP_UI_M_BTN_MAIN_PROD_1;
    	}
    
    	public HtmlCommandButton getCOMP_UI_M_COVERGROUP_LOV_BTN_1() {
    		return COMP_UI_M_COVERGROUP_LOV_BTN_1;
    	}
    
    	public void setCOMP_UI_M_COVERGROUP_LOV_BTN_1(HtmlCommandButton COMP_UI_M_COVERGROUP_LOV_BTN_1) {
    		this.COMP_UI_M_COVERGROUP_LOV_BTN_1 = COMP_UI_M_COVERGROUP_LOV_BTN_1;
    	}
    
    	public PT_IL_POL_COVER_GROUP_1 getPT_IL_POL_COVER_GROUP_1_BEAN() {
    		return PT_IL_POL_COVER_GROUP_1_BEAN;
    	}
    
    	public void setPT_IL_POL_COVER_GROUP_1_BEAN(PT_IL_POL_COVER_GROUP_1 PT_IL_POL_COVER_GROUP_1_BEAN) {
    		this.PT_IL_POL_COVER_GROUP_1_BEAN = PT_IL_POL_COVER_GROUP_1_BEAN;
    	}
    
    	public List<PT_IL_POL_COVER_GROUP_1> getDataList_PT_IL_POL_COVER_GROUP_1() {
    		return dataList_PT_IL_POL_COVER_GROUP_1;
    	}
    
    	public void setDataListPT_IL_POL_COVER_GROUP_1(List<PT_IL_POL_COVER_GROUP_1> dataList_PT_IL_POL_COVER_GROUP_1) {
    		this.dataList_PT_IL_POL_COVER_GROUP_1 = dataList_PT_IL_POL_COVER_GROUP_1;
    	}
    
    public void addRow(ActionEvent event){
    try{
    if (isINSERT_ALLOWED()){
    
    PT_IL_POL_COVER_GROUP_1_BEAN = new PT_IL_POL_COVER_GROUP_1();
    resetAllComponent();
    resetSelectedRow();
    }else{
    
    getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
    }
    
    }catch(Exception exc){
    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
    getErrorMap().put("addRow",exc.getMessage());
    }
    
    }
    
    public void deleteRow(ActionEvent event){
        try{
        if (isDELETE_ALLOWED()){
            helper.onCheckDeleteMaster(PT_IL_POL_COVER_GROUP_1_BEAN);
            new CRUDHandler().executeDelete(PT_IL_POL_COVER_GROUP_1_BEAN,CommonUtils.getConnection());
            helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), compositeAction);
            getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
            getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
            dataList_PT_IL_POL_COVER_GROUP_1.remove(PT_IL_POL_COVER_GROUP_1_BEAN);
            if(dataList_PT_IL_POL_COVER_GROUP_1.size()>0){
                PT_IL_POL_COVER_GROUP_1_BEAN=dataList_PT_IL_POL_COVER_GROUP_1.get(0);
            }else if(dataList_PT_IL_POL_COVER_GROUP_1.size()==0){
                addRow(null);
            }
            resetAllComponent();
            PT_IL_POL_COVER_GROUP_1_BEAN.setRowSelected(true);
            }else{
                getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
                getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"));
            }
            
        }catch(Exception exc){
            getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
            getErrorMap().put("deleteRow",exc.getMessage());
        }
    
    }
    
    public void postRecord(ActionEvent event){
    	String message = null;
    	try{
	    if(PT_IL_POL_COVER_GROUP_1_BEAN.getROWID()==null && isINSERT_ALLOWED()){
		helper.preInsert(PT_IL_POL_COVER_GROUP_1_BEAN,compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN());
		new CRUDHandler().executeInsert(PT_IL_POL_COVER_GROUP_1_BEAN,CommonUtils.getConnection());
		helper.post_insert(PT_IL_POL_COVER_GROUP_1_BEAN,compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN());
		message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
		dataList_PT_IL_POL_COVER_GROUP_1.add(PT_IL_POL_COVER_GROUP_1_BEAN);
	    } else if (PT_IL_POL_COVER_GROUP_1_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
		helper.preUpdate(PT_IL_POL_COVER_GROUP_1_BEAN);
		new CRUDHandler().executeUpdate(PT_IL_POL_COVER_GROUP_1_BEAN,CommonUtils.getConnection());
		helper.post_update(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
				compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
				compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN(),
				compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN());
		message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
	    }

	    PT_IL_POL_COVER_GROUP_1_BEAN.setRowSelected(true);
	    getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		getWarningMap().put("postRecord",message);
		
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    "Record not Inserted/Updated :: " + exc.getMessage());
	    getErrorMap().put("postRecord",
		    "Record not Inserted/Updated :: " + exc.getMessage());
	}
    
    }
    
    public void displayRecords(){
	CommonUtils.clearMaps(this);
	try {
	    resetSelectedRow();
	    PT_IL_POL_COVER_GROUP_1_BEAN = (PT_IL_POL_COVER_GROUP_1) dataTable.getRowData();
	    PT_IL_POL_COVER_GROUP_1_BEAN.setRowSelected(true);
	    resetAllComponent();
	} catch (Exception exc) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,   exc.getMessage());
	    getErrorMap().put("displayRecords", exc.getMessage());
	}
    }


	/**
	 * Instantiates all components in PT_IL_POL_COVER_GROUP_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_PROD_CODE				 = new HtmlInputText();
		COMP_PCG_CODE					 = new HtmlInputText();
		COMP_PCG_RATE					 = new HtmlInputText();
		COMP_PCG_RATE_PER				 = new HtmlInputText();
		COMP_PCG_FC_PREM				 = new HtmlInputText();
		COMP_PCG_LC_PREM				 = new HtmlInputText();
		COMP_UI_M_PCD_CODE_DESC				 = new HtmlInputText();
		COMP_PCG_ORG_FC_PREM				 = new HtmlInputText();
		COMP_PCG_ORG_LC_PREM				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UI_M_PROD_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PCG_CODE_LABEL				 = new HtmlOutputLabel();
		COMP_PCG_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_PCG_RATE_PER_LABEL				 = new HtmlOutputLabel();
		COMP_PCG_FC_PREM_LABEL				 = new HtmlOutputLabel();
		COMP_PCG_LC_PREM_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_PCD_CODE_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_PCG_ORG_FC_PREM_LABEL			 = new HtmlOutputLabel();
		COMP_PCG_ORG_LC_PREM_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BTN_COVER_DTLS			 = new HtmlCommandButton();
		COMP_UI_M_BTN_MAIN_PROD_1			 = new HtmlCommandButton();
		COMP_UI_M_COVERGROUP_LOV_BTN_1			 = new HtmlCommandButton();

	}
	
	public String coverDetail(){
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_ADDL_COVER_1";
	return 	reString;
	}

	public String back(){
		String reString = null;
		reString = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS_1";
	return 	reString;
	}

    
    private void resetSelectedRow(){
    Iterator<PT_IL_POL_COVER_GROUP_1> PT_IL_POL_COVER_GROUP_1_ITR = dataList_PT_IL_POL_COVER_GROUP_1.iterator();while (PT_IL_POL_COVER_GROUP_1_ITR.hasNext()) {
    PT_IL_POL_COVER_GROUP_1_ITR.next().setRowSelected(false);}
    }
    
    private void resetAllComponent(){
    COMP_UI_M_PROD_CODE.resetValue();
    COMP_PCG_CODE.resetValue();
    COMP_PCG_RATE.resetValue();
    COMP_PCG_RATE_PER.resetValue();
    COMP_PCG_FC_PREM.resetValue();
    COMP_PCG_LC_PREM.resetValue();
    COMP_UI_M_PCD_CODE_DESC.resetValue();
    COMP_PCG_ORG_FC_PREM.resetValue();
    COMP_PCG_ORG_LC_PREM.resetValue();
    }
    
    	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
    	}
    
    	public UIData getDataTable() {
    		return dataTable;
    	}
    	public void saveRecord() {
    		try {
    			CommonUtils.getConnection().commit();
    		} catch (Exception e) {
    			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
    			getErrorMap().put("SAVE", e.getMessage());
    		}
    	}
    
    
    	public void fireFieldValidation(ActionEvent actionEvent) {
    		UIInput input = (UIInput) actionEvent.getComponent().getParent();
    		ErrorHelpUtil.validate(input, getErrorMap());
    	}
    	
    
    	 public ArrayList<com.iii.premia.common.bean.LovBean> lovPCG_CODE(Object currValue) {
    		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
    		ListItemUtil listitemutil = new ListItemUtil();
    		try {
    		 //   P_CALL_LOV('PT_IL_POL_COVER_GROUP.PCG_CODE',:PT_IL_POL_APPL_PROD_1.PAPP_PROD_CODE);--Rev 1.9 PAPP_PROD_CODE has added
    		    suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
    			    "PT_IL_POL_COVER_GROUP", "PCG_CODE", 
    			    compositeAction.getPT_IL_POL_APPL_PROD_ACTION_BEAN().getPT_IL_POL_APPL_PROD_BEAN().getPAPP_PROD_CODE(),
    			    null, null, null,  null, (String) currValue);
    		} catch (Exception e) {
    		    e.printStackTrace();
    		}
    		return suggestionList;
    	    }
    	 
    	 
    	  public void validatePCG_CODE(FacesContext facesContext,
    		    UIComponent component, Object value) throws ValidatorException {
    
    		try {
    		    String componentValue = (String) COMP_PCG_CODE.getSubmittedValue();
    		    PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_CODE((String)value);
    		    helper.PCG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_COVER_GROUP_1_BEAN,componentValue) ;
    		    COMP_PCG_CODE.resetValue();
    		    COMP_UI_M_PCD_CODE_DESC.resetValue();
    		} catch (Exception exception) {
    		    exception.printStackTrace();
    		    throw new ValidatorException(new FacesMessage(exception
    			    .getMessage()));
    		} finally {
    		    try {
    			ErrorHelpUtil.getWarningForProcedure(CommonUtils
    				.getConnection(), "PCG_CODE", getWarningMap());
    		    } catch (Exception e) {
    			e.printStackTrace();
    		    }
    		}
    	    }
    	  public void validatePCG_RATE_PER(FacesContext facesContext,
    		  UIComponent component, Object value) throws ValidatorException {
    	      
    	      try {
    		  PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_RATE_PER((Double)value);
    		  helper.PCG_RATE_PER_WHEN_VALIDATE_ITEM((Double)value);
    		  COMP_PCG_RATE_PER.resetValue();
    	      } catch (Exception exception) {
    		  exception.printStackTrace();
    		  throw new ValidatorException(new FacesMessage(exception
    			  .getMessage()));
    	      } finally {
    		  try {
    		      ErrorHelpUtil.getWarningForProcedure(CommonUtils
    			      .getConnection(), "PCG_RATE_PER", getWarningMap());
    		  } catch (Exception e) {
    		      e.printStackTrace();
    		  }
    	      }
    	  }
    	  public void validatePCG_RATE(FacesContext facesContext,
    		  UIComponent component, Object value) throws ValidatorException {
    	      
    	      try {
    		  PT_IL_POL_COVER_GROUP_1_BEAN.setPCG_RATE((Double)value);
    		  helper.PCG_RATE_WHEN_VALIDATE_ITEM( (Double)value) ;
    		  COMP_PCG_RATE.resetValue();
    	      } catch (Exception exception) {
    		  exception.printStackTrace();
    		  throw new ValidatorException(new FacesMessage(exception
    			  .getMessage()));
    	      } finally {
    		  try {
    		      ErrorHelpUtil.getWarningForProcedure(CommonUtils
    			      .getConnection(), "PCG_RATE", getWarningMap());
    		  } catch (Exception e) {
    		      e.printStackTrace();
    		  }
    	      }
    	  }
    	
    	public void onLoad(PhaseEvent event) {
    	try {
    	    if (isBlockFlag()) {
    		helper.whenNewBlockInstance(compositeAction);
    		helper.whenNewRecordInstance(PT_IL_POL_COVER_GROUP_1_BEAN,
    				compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN());
    		helper.executeQuery(compositeAction);
    		helper.onPopulateDetail(compositeAction);
    		if(PT_IL_POL_COVER_GROUP_1_BEAN.getROWID()!=null){
		    helper.postQuery(PT_IL_POL_COVER_GROUP_1_BEAN);
		}
    		setBlockFlag(false);
    	    }
    	} catch (Exception e) {
    	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    		    e.getMessage());
    	    getErrorMap().put("onLoad", e.getMessage());
    	}
        }
    
    	/**
    	 * Disables all components in PT_IL_POL_COVER_GROUP_1_ACTION
    	 */
    	public void disableAllComponent(boolean disabled){
    		// Disabling HtmlInputText
    		COMP_UI_M_PROD_CODE.setDisabled(disabled);
    		COMP_PCG_CODE.setDisabled(disabled);
    		COMP_PCG_RATE.setDisabled(disabled);
    		COMP_PCG_RATE_PER.setDisabled(disabled);
    		COMP_PCG_FC_PREM.setDisabled(disabled);
    		COMP_PCG_LC_PREM.setDisabled(disabled);
    		COMP_UI_M_PCD_CODE_DESC.setDisabled(disabled);
    		COMP_PCG_ORG_FC_PREM.setDisabled(disabled);
    		COMP_PCG_ORG_LC_PREM.setDisabled(disabled);
    
    		// Disabling HtmlCommandButton
    		COMP_UI_M_BTN_COVER_DTLS.setDisabled(disabled);
    		COMP_UI_M_BTN_MAIN_PROD_1.setDisabled(disabled);
    		COMP_UI_M_COVERGROUP_LOV_BTN_1.setDisabled(disabled);
    
    	}
    
    
    	/**
    	 * Instantiates all components in PT_IL_POL_COVER_GROUP_1_ACTION
    	 */
    	/*public void instantiateAllComponent(){
    		// Instantiating HtmlInputText
    		COMP_UI_M_PROD_CODE				 = new HtmlInputText();
    		COMP_PCG_CODE					 = new HtmlInputText();
    		COMP_PCG_RATE					 = new HtmlInputText();
    		COMP_PCG_RATE_PER				 = new HtmlInputText();
    		COMP_PCG_FC_PREM				 = new HtmlInputText();
    		COMP_PCG_LC_PREM				 = new HtmlInputText();
    		COMP_UI_M_PCD_CODE_DESC				 = new HtmlInputText();
    		COMP_PCG_ORG_FC_PREM				 = new HtmlInputText();
    		COMP_PCG_ORG_LC_PREM				 = new HtmlInputText();
    
    		// Instantiating HtmlOutputLabel
    		COMP_UI_M_PROD_CODE_LABEL			 = new HtmlOutputLabel();
    		COMP_PCG_CODE_LABEL				 = new HtmlOutputLabel();
    		COMP_PCG_RATE_LABEL				 = new HtmlOutputLabel();
    		COMP_PCG_RATE_PER_LABEL				 = new HtmlOutputLabel();
    		COMP_PCG_FC_PREM_LABEL				 = new HtmlOutputLabel();
    		COMP_PCG_LC_PREM_LABEL				 = new HtmlOutputLabel();
    		COMP_UI_M_PCD_CODE_DESC_LABEL			 = new HtmlOutputLabel();
    		COMP_PCG_ORG_FC_PREM_LABEL			 = new HtmlOutputLabel();
    		COMP_PCG_ORG_LC_PREM_LABEL			 = new HtmlOutputLabel();
    
    		// Instantiating HtmlCommandButton
    		COMP_UI_M_BTN_COVER_DTLS			 = new HtmlCommandButton();
    		COMP_UI_M_BTN_MAIN_PROD_1			 = new HtmlCommandButton();
    		COMP_UI_M_COVERGROUP_LOV_BTN_1			 = new HtmlCommandButton();
    
    	}
    */
    
    
    }
