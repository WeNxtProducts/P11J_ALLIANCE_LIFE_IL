package com.iii.pel.forms.PILM042;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.login.servlet.ConnectionAgentServlet;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_DUDH_DEF_CODE_LABEL;

	private HtmlInputText COMP_DUDH_DEF_CODE;

	private HtmlOutputLabel COMP_DUDH_DESC_LABEL;

	private HtmlInputText COMP_DUDH_DESC;

	private HtmlOutputLabel COMP_DUDH_SHORT_DESC_LABEL;

	private HtmlInputText COMP_DUDH_SHORT_DESC;

	private HtmlOutputLabel COMP_DUDH_LONG_DESC_LABEL;

	private HtmlInputText COMP_DUDH_LONG_DESC;

	private HtmlOutputLabel COMP_DUDH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_DUDH_EFF_FM_DT;

	private HtmlOutputLabel COMP_DUDH_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_DUDH_EFF_TO_DT;

	private HtmlOutputLabel COMP_DUDH_BL_DESC_LABEL;

	private HtmlInputText COMP_DUDH_BL_DESC;

	private HtmlOutputLabel COMP_DUDH_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_DUDH_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_DUDH_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_DUDH_BL_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_BILNGUAL_BUT;

	private HtmlCommandButton COMP_UI_M_EDIT_DESC;

	private HtmlCommandButton COMP_UI_M_EDIT_LONG_DESC;

	private PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN;
	
	private List fetchList = new ArrayList();
	
	private int rowIndex ;

	private UIData dataTable;
	
	
	
	public PM_IL_DATA_UPLOAD_DEFN_HDR_HELPER helper ;
	
	PILM042_COMPOSITE_ACTION compositeAction ;
	
	

	public PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION() {
		instantiateAllComponent();
		PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN = new PM_IL_DATA_UPLOAD_DEFN_HDR();
		helper = new PM_IL_DATA_UPLOAD_DEFN_HDR_HELPER();
   }

	public HtmlOutputLabel getCOMP_DUDH_DEF_CODE_LABEL() {
		return COMP_DUDH_DEF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_DEF_CODE() {
		return COMP_DUDH_DEF_CODE;
	}

	public void setCOMP_DUDH_DEF_CODE_LABEL(HtmlOutputLabel COMP_DUDH_DEF_CODE_LABEL) {
		this.COMP_DUDH_DEF_CODE_LABEL = COMP_DUDH_DEF_CODE_LABEL;
	}

	public void setCOMP_DUDH_DEF_CODE(HtmlInputText COMP_DUDH_DEF_CODE) {
		this.COMP_DUDH_DEF_CODE = COMP_DUDH_DEF_CODE;
	}

	public HtmlOutputLabel getCOMP_DUDH_DESC_LABEL() {
		return COMP_DUDH_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_DESC() {
		return COMP_DUDH_DESC;
	}

	public void setCOMP_DUDH_DESC_LABEL(HtmlOutputLabel COMP_DUDH_DESC_LABEL) {
		this.COMP_DUDH_DESC_LABEL = COMP_DUDH_DESC_LABEL;
	}

	public void setCOMP_DUDH_DESC(HtmlInputText COMP_DUDH_DESC) {
		this.COMP_DUDH_DESC = COMP_DUDH_DESC;
	}

	public HtmlOutputLabel getCOMP_DUDH_SHORT_DESC_LABEL() {
		return COMP_DUDH_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_SHORT_DESC() {
		return COMP_DUDH_SHORT_DESC;
	}

	public void setCOMP_DUDH_SHORT_DESC_LABEL(HtmlOutputLabel COMP_DUDH_SHORT_DESC_LABEL) {
		this.COMP_DUDH_SHORT_DESC_LABEL = COMP_DUDH_SHORT_DESC_LABEL;
	}

	public void setCOMP_DUDH_SHORT_DESC(HtmlInputText COMP_DUDH_SHORT_DESC) {
		this.COMP_DUDH_SHORT_DESC = COMP_DUDH_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_DUDH_LONG_DESC_LABEL() {
		return COMP_DUDH_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_LONG_DESC() {
		return COMP_DUDH_LONG_DESC;
	}

	public void setCOMP_DUDH_LONG_DESC_LABEL(HtmlOutputLabel COMP_DUDH_LONG_DESC_LABEL) {
		this.COMP_DUDH_LONG_DESC_LABEL = COMP_DUDH_LONG_DESC_LABEL;
	}

	public void setCOMP_DUDH_LONG_DESC(HtmlInputText COMP_DUDH_LONG_DESC) {
		this.COMP_DUDH_LONG_DESC = COMP_DUDH_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_DUDH_EFF_FM_DT_LABEL() {
		return COMP_DUDH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DUDH_EFF_FM_DT() {
		return COMP_DUDH_EFF_FM_DT;
	}

	public void setCOMP_DUDH_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_DUDH_EFF_FM_DT_LABEL) {
		this.COMP_DUDH_EFF_FM_DT_LABEL = COMP_DUDH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_DUDH_EFF_FM_DT(HtmlCalendar COMP_DUDH_EFF_FM_DT) {
		this.COMP_DUDH_EFF_FM_DT = COMP_DUDH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_DUDH_EFF_TO_DT_LABEL() {
		return COMP_DUDH_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DUDH_EFF_TO_DT() {
		return COMP_DUDH_EFF_TO_DT;
	}

	public void setCOMP_DUDH_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_DUDH_EFF_TO_DT_LABEL) {
		this.COMP_DUDH_EFF_TO_DT_LABEL = COMP_DUDH_EFF_TO_DT_LABEL;
	}

	public void setCOMP_DUDH_EFF_TO_DT(HtmlCalendar COMP_DUDH_EFF_TO_DT) {
		this.COMP_DUDH_EFF_TO_DT = COMP_DUDH_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_DUDH_BL_DESC_LABEL() {
		return COMP_DUDH_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_BL_DESC() {
		return COMP_DUDH_BL_DESC;
	}

	public void setCOMP_DUDH_BL_DESC_LABEL(HtmlOutputLabel COMP_DUDH_BL_DESC_LABEL) {
		this.COMP_DUDH_BL_DESC_LABEL = COMP_DUDH_BL_DESC_LABEL;
	}

	public void setCOMP_DUDH_BL_DESC(HtmlInputText COMP_DUDH_BL_DESC) {
		this.COMP_DUDH_BL_DESC = COMP_DUDH_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_DUDH_BL_SHORT_DESC_LABEL() {
		return COMP_DUDH_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_BL_SHORT_DESC() {
		return COMP_DUDH_BL_SHORT_DESC;
	}

	public void setCOMP_DUDH_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_DUDH_BL_SHORT_DESC_LABEL) {
		this.COMP_DUDH_BL_SHORT_DESC_LABEL = COMP_DUDH_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_DUDH_BL_SHORT_DESC(HtmlInputText COMP_DUDH_BL_SHORT_DESC) {
		this.COMP_DUDH_BL_SHORT_DESC = COMP_DUDH_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_DUDH_BL_LONG_DESC_LABEL() {
		return COMP_DUDH_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DUDH_BL_LONG_DESC() {
		return COMP_DUDH_BL_LONG_DESC;
	}

	public void setCOMP_DUDH_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_DUDH_BL_LONG_DESC_LABEL) {
		this.COMP_DUDH_BL_LONG_DESC_LABEL = COMP_DUDH_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_DUDH_BL_LONG_DESC(HtmlInputText COMP_DUDH_BL_LONG_DESC) {
		this.COMP_DUDH_BL_LONG_DESC = COMP_DUDH_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BILNGUAL_BUT() {
		return COMP_UI_M_BILNGUAL_BUT;
	}

	public void setCOMP_UI_M_BILNGUAL_BUT(HtmlCommandButton COMP_UI_M_BILNGUAL_BUT) {
		this.COMP_UI_M_BILNGUAL_BUT = COMP_UI_M_BILNGUAL_BUT;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_DESC() {
		return COMP_UI_M_EDIT_DESC;
	}

	public void setCOMP_UI_M_EDIT_DESC(HtmlCommandButton COMP_UI_M_EDIT_DESC) {
		this.COMP_UI_M_EDIT_DESC = COMP_UI_M_EDIT_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_EDIT_LONG_DESC() {
		return COMP_UI_M_EDIT_LONG_DESC;
	}

	public void setCOMP_UI_M_EDIT_LONG_DESC(HtmlCommandButton COMP_UI_M_EDIT_LONG_DESC) {
		this.COMP_UI_M_EDIT_LONG_DESC = COMP_UI_M_EDIT_LONG_DESC;
	}

	public PM_IL_DATA_UPLOAD_DEFN_HDR getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN() {
		return PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN;
	}

	public void setPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN) {
		this.PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN = PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN;
	}

	public List getFetchList() {
		return fetchList;
	}

	public void setFetchList(List fetchList) {
		this.fetchList = fetchList;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	CommonUtils util = new CommonUtils();	
	


	
	   

	  public String saveRecord() {
			String message = null;
			try {
				if (PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getROWID() != null) {
					if (isUPDATE_ALLOWED()) {
						helper.preUpdate(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
						new CRUDHandler().executeInsert(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,CommonUtils.getConnection());
						message = Messages.getString("messageProperties","errorPanel$message$update");
					} else {
						message = Messages.getString("messageProperties","errorPanel$message$updatenotallowed");
						throw new Exception(message);
					}
				} else {
					if (isINSERT_ALLOWED()) {
						helper.preInsert(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
						new CRUDHandler().executeInsert(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,CommonUtils.getConnection());
						message = Messages.getString("messageProperties","errorPanel$message$save");
					} else {
						message = Messages.getString("messageProperties","errorPanel$message$insertnotallowed");
						throw new Exception(message);
					}
				}
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("Save", message);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}finally{try{CommonUtils.getConnection().commit();}catch(Exception exception){exception.printStackTrace();}}
			return null;
		}
		
		public String deleteRecord(){
			String message = null;
			 PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE delegate=new PM_IL_DATA_UPLOAD_DEFN_HDR_DELEGATE();
			try {
				if (isDELETE_ALLOWED()) {
					int deleteCount = delegate.delete(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN, compositeAction.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN());
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN = new PM_IL_DATA_UPLOAD_DEFN_HDR();
					compositeAction.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN().setPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(new PM_IL_DATA_UPLOAD_DEFN_DTL());

						message = Messages.getString("messageProperties","errorPanel$message$delete");

				} else {
					message = Messages.getString("messageProperties","errorPanel$message$deletenotallowed");
					throw new Exception(message);
				}
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("DELETE", message);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("DELETE", e.getMessage());
			}
			return "";
		}
		
		public String backToSearch() {
			CommonUtils.clearMaps(this);
			return SearchConstants.BACK_TO_SEARCH_PAGE;

		}

		public void onLoad(PhaseEvent event) {
			try {
				if (isFormFlag()) {
					setFormFlag(false);
				}
				if (isBlockFlag()) {
					helper.executeQuery(this);
					if (PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getROWID() != null) {
						//helper.postQuery(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					} else {
						//helper.whenCreateRecord(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
					}
					//whenNewRecordInstance(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
					setBlockFlag(false);
				}
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("onLoad", e.getMessage());
			}
		}

		public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
		
		public void validatorDefCode(FacesContext context,UIComponent component, Object value) {
			try {
				if(value!=null && PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getROWID()==null){
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_DEF_CODE((String)value);
					helper.defnCodeVaidator(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE());
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validatorShortDesc(FacesContext context,UIComponent component, Object value) {
			try {
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_DESC((String)value);
					helper.shortDescValidator(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
					COMP_DUDH_SHORT_DESC.resetValue();
					COMP_DUDH_LONG_DESC.resetValue();
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validatorLongDesc(FacesContext context,UIComponent component, Object value) {
			try {
				if(value!=null){
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_LONG_DESC((String)value);
					helper.longDescValidator(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validatorEffectivDateFrom(FacesContext context,UIComponent component, Object value) {
			try {
				if(value!=null){
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_EFF_FM_DT((Date)value);
					helper.effectivFromDateValidator(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		
		public void validatorEffectivDateTo(FacesContext context,UIComponent component, Object value) {
			try {
				if(value!=null){
					PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.setDUDH_EFF_TO_DT((Date)value);
					helper.effectiveToDateValidator(PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		

		/**
		 * Instantiates all components in PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION
		 */
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_DUDH_DEF_CODE				 = new HtmlInputText();
			COMP_DUDH_DESC					 = new HtmlInputText();
			COMP_DUDH_SHORT_DESC				 = new HtmlInputText();
			COMP_DUDH_LONG_DESC				 = new HtmlInputText();
			COMP_DUDH_BL_DESC				 = new HtmlInputText();
			COMP_DUDH_BL_SHORT_DESC				 = new HtmlInputText();
			COMP_DUDH_BL_LONG_DESC				 = new HtmlInputText();

			// Instantiating HtmlCalendar
			COMP_DUDH_EFF_FM_DT				 = new HtmlCalendar();
			COMP_DUDH_EFF_TO_DT				 = new HtmlCalendar();

			// Instantiating HtmlCommandButton
			COMP_UI_M_BILNGUAL_BUT				 = new HtmlCommandButton();
			COMP_UI_M_EDIT_DESC				 = new HtmlCommandButton();
			COMP_UI_M_EDIT_LONG_DESC			 = new HtmlCommandButton();

		}

		/**
		 * Resets all components in PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION
		 */
		public void resetAllComponent(){
			// Reseting HtmlInputText
			COMP_DUDH_DEF_CODE.resetValue();
			COMP_DUDH_DESC.resetValue();
			COMP_DUDH_SHORT_DESC.resetValue();
			COMP_DUDH_LONG_DESC.resetValue();
			COMP_DUDH_BL_DESC.resetValue();
			COMP_DUDH_BL_SHORT_DESC.resetValue();
			COMP_DUDH_BL_LONG_DESC.resetValue();

			// Reseting HtmlCalendar
			COMP_DUDH_EFF_FM_DT.resetValue();
			COMP_DUDH_EFF_TO_DT.resetValue();
		}

		/**
		 * Disables all components in PM_IL_DATA_UPLOAD_DEFN_HDR_ACTION
		 */
		public void disableAllComponent(boolean disabled){
			// Disabling HtmlInputText
			COMP_DUDH_DEF_CODE.setDisabled(disabled);
			COMP_DUDH_DESC.setDisabled(disabled);
			COMP_DUDH_SHORT_DESC.setDisabled(disabled);
			COMP_DUDH_LONG_DESC.setDisabled(disabled);
			COMP_DUDH_BL_DESC.setDisabled(disabled);
			COMP_DUDH_BL_SHORT_DESC.setDisabled(disabled);
			COMP_DUDH_BL_LONG_DESC.setDisabled(disabled);

			// Disabling HtmlCalendar
			COMP_DUDH_EFF_FM_DT.setDisabled(disabled);
			COMP_DUDH_EFF_TO_DT.setDisabled(disabled);

			// Disabling HtmlCommandButton
			COMP_UI_M_BILNGUAL_BUT.setDisabled(disabled);
			COMP_UI_M_EDIT_DESC.setDisabled(disabled);
			COMP_UI_M_EDIT_LONG_DESC.setDisabled(disabled);

		}



}
