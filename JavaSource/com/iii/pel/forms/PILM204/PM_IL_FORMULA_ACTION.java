package com.iii.pel.forms.PILM204;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlPickList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_FORMULA_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_FRM_CODE_LABEL;

	private HtmlInputText COMP_FRM_CODE;

	private HtmlOutputLabel COMP_FRM_DESC_LABEL;

	private HtmlInputText COMP_FRM_DESC;

	private HtmlOutputLabel COMP_FRM_FORMULA_LABEL;

	private HtmlInputText COMP_FRM_FORMULA;
	private HtmlInputText  COMP_FRM_HIDE;
	private HtmlInputText  COMP_FRM_HIDE_TO;
	
	
	public HtmlInputText getCOMP_FRM_HIDE() {
		return COMP_FRM_HIDE;
	}

	public void setCOMP_FRM_HIDE(HtmlInputText cOMP_FRM_HIDE) {
		COMP_FRM_HIDE = cOMP_FRM_HIDE;
	}

	public HtmlInputText getCOMP_FRM_HIDE_TO() {
		return COMP_FRM_HIDE_TO;
	}

	public void setCOMP_FRM_HIDE_TO(HtmlInputText cOMP_FRM_HIDE_TO) {
		COMP_FRM_HIDE_TO = cOMP_FRM_HIDE_TO;
	}

	private HtmlPickList COMP_UI_PICK;

	private PM_IL_FORMULA PM_IL_FORMULA_BEAN;

	PM_IL_FORMULA_DELEGATE delegate = new PM_IL_FORMULA_DELEGATE();

	public PM_IL_FORMULA_COMPOSITEBEAN compositeAction;
	
	
	 private List<PM_IL_FORMULA_PARAM> listParam = new ArrayList<PM_IL_FORMULA_PARAM>();
	 private List<PM_IL_FORMULA_PARAM> listParamDestination = new ArrayList<PM_IL_FORMULA_PARAM>();
	 private List<String> listParam1 = new ArrayList<String>();
	 private List<String> listParamDestination1 = null;
	 private List<SelectItem> listOperator = new ArrayList<SelectItem>();
	 
	public List<SelectItem> getListOperator() {
		return listOperator;
	}

	public void setListOperator(List<SelectItem> listOperator) {
		this.listOperator = listOperator;
	}

	public PM_IL_FORMULA_ACTION() {
		ArrayList<SelectItem> tempList = new ArrayList<SelectItem>();
		PM_IL_FORMULA_BEAN = new PM_IL_FORMULA();
		listParamDestination1 = new ArrayList<String>();
		tempList.add(new SelectItem("+","+"));
		tempList.add(new SelectItem("-","-"));
		tempList.add(new SelectItem("/","/"));
		tempList.add(new SelectItem("*","*"));
		setListOperator(tempList);
		//listParam = compositeAction.getPM_IL_FORMULA_PARAM_ACTION_BEAN().getDataList_PM_IL_FORMULA_PARAM();
	}

	public HtmlOutputLabel getCOMP_FRM_CODE_LABEL() {
		return COMP_FRM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FRM_CODE() {
		return COMP_FRM_CODE;
	}

	public void setCOMP_FRM_CODE_LABEL(HtmlOutputLabel COMP_FRM_CODE_LABEL) {
		this.COMP_FRM_CODE_LABEL = COMP_FRM_CODE_LABEL;
	}

	public void setCOMP_FRM_CODE(HtmlInputText COMP_FRM_CODE) {
		this.COMP_FRM_CODE = COMP_FRM_CODE;
	}

	public HtmlOutputLabel getCOMP_FRM_DESC_LABEL() {
		return COMP_FRM_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FRM_DESC() {
		return COMP_FRM_DESC;
	}

	public void setCOMP_FRM_DESC_LABEL(HtmlOutputLabel COMP_FRM_DESC_LABEL) {
		this.COMP_FRM_DESC_LABEL = COMP_FRM_DESC_LABEL;
	}

	public void setCOMP_FRM_DESC(HtmlInputText COMP_FRM_DESC) {
		this.COMP_FRM_DESC = COMP_FRM_DESC;
	}

	public HtmlOutputLabel getCOMP_FRM_FORMULA_LABEL() {
		return COMP_FRM_FORMULA_LABEL;
	}

	public HtmlInputText getCOMP_FRM_FORMULA() {
		return COMP_FRM_FORMULA;
	}

	public void setCOMP_FRM_FORMULA_LABEL(HtmlOutputLabel COMP_FRM_FORMULA_LABEL) {
		this.COMP_FRM_FORMULA_LABEL = COMP_FRM_FORMULA_LABEL;
	}

	public void setCOMP_FRM_FORMULA(HtmlInputText COMP_FRM_FORMULA) {
		this.COMP_FRM_FORMULA = COMP_FRM_FORMULA;
	}

	public PM_IL_FORMULA getPM_IL_FORMULA_BEAN() {
		return PM_IL_FORMULA_BEAN;
	}

	public void setPM_IL_FORMULA_BEAN(PM_IL_FORMULA PM_IL_FORMULA_BEAN) {
		this.PM_IL_FORMULA_BEAN = PM_IL_FORMULA_BEAN;
	}

	public void saveRecord() {
		CommonUtils.clearMaps(this);
		String message = null;
		Connection conn = null;
		try {
			if (PM_IL_FORMULA_BEAN.getROWID() != null) {
				PM_IL_FORMULA_BEAN.setFRM_UPD_DT(null);
				conn = CommonUtils.getConnection();
				conn.commit();
				
				if (isUPDATE_ALLOWED()) {
					System.out.println("getFRM_CODE         "+PM_IL_FORMULA_BEAN.getFRM_CODE()+" browId        "+PM_IL_FORMULA_BEAN.getROWID());
					
					PM_IL_FORMULA_BEAN.setFRM_UPD_DT(new CommonUtils().getCurrentDate());
					PM_IL_FORMULA_BEAN.setFRM_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
					
					System.out.println("getFRM_UPD_DT        "+PM_IL_FORMULA_BEAN.getFRM_UPD_DT());
					System.out.println("setFRM_UPD_UID        "+PM_IL_FORMULA_BEAN.getFRM_UPD_UID());
					
					new CRUDHandler().executeUpdate(PM_IL_FORMULA_BEAN,
							conn);
					/*PreparedStatement ps = conn.prepareStatement("update PM_IL_FORMULA set FRM_FORMULA = ? where rowid = ? ");
					ps.setString(1, PM_IL_FORMULA_BEAN.getFRM_FORMULA());
					ps.setString(2, PM_IL_FORMULA_BEAN.getROWID());
					ps.executeUpdate();
					conn.commit();*/
					
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					//added by agalya 
					conn = CommonUtils.getConnection();
					new CRUDHandler().executeInsert(PM_IL_FORMULA_BEAN,
							conn);
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
				}
			}
			conn.commit();
		}

		catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

	}
	
	
	public void fireFieldValidation_Formula(ActionEvent event) {
		CommonUtils.clearMaps(this);
		StringBuffer str = new StringBuffer();
		if(PM_IL_FORMULA_BEAN.getFRM_FORMULA() != null){
			str.append(PM_IL_FORMULA_BEAN.getFRM_FORMULA());
		}
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if(str != null){
			str.append(value);
			PM_IL_FORMULA_BEAN.setFRM_FORMULA(str.toString());
		}else{
			PM_IL_FORMULA_BEAN.setFRM_FORMULA(value);
		}
		COMP_FRM_FORMULA.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void fireFieldValidation_Operator(ActionEvent event) {
		CommonUtils.clearMaps(this);
		StringBuffer str = new StringBuffer();
		if(PM_IL_FORMULA_BEAN.getFRM_FORMULA() != null){
			str.append(PM_IL_FORMULA_BEAN.getFRM_FORMULA());
		}
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		if(str != null){
			str.append(value);
			PM_IL_FORMULA_BEAN.setFRM_FORMULA(str.toString());
		}else{
			PM_IL_FORMULA_BEAN.setFRM_FORMULA(value);
		}
		COMP_FRM_FORMULA.resetValue();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateList(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String value = (String) input.getSubmittedValue();
		listSElectDest.add(value);
		
	}
	
	public void validate_Formula(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			System.out.println("Entered into validate formula");
			UIInput input = (UIInput) event.getComponent().getParent();
			String value = (String) input.getSubmittedValue();
			PM_IL_FORMULA_BEAN.setFRM_FORMULA((String)value);
			System.out.println(" validate formula--->"+PM_IL_FORMULA_BEAN.getFRM_FORMULA());
			PM_IL_FORMULA_BEAN.setFRM_HIDE(PM_IL_FORMULA_BEAN.getFRM_FORMULA());
			COMP_FRM_HIDE.resetValue();
			Connection conn = null;
			conn = CommonUtils.getConnection();
			conn.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			/*throw new ValidatorException(new FacesMessage(e
					.getMessage()));*/
		}
		}
	
	public  void resetvalue(ActionEvent event){
		CommonUtils.clearMaps(this);
		PM_IL_FORMULA_BEAN.setFRM_FORMULA("");
		COMP_FRM_FORMULA.resetValue();
	}

	public void codeWhenValidation(FacesContext context, UIComponent component,
			Object value) {

		try {
			if (value != null) {

				String code = (String) value;
				PM_IL_FORMULA_DELEGATE delegate = new PM_IL_FORMULA_DELEGATE();
				/*
				 * [BugId:TRACK_PREMIAGDC_GL.10.5-00177: Action Parameter Added.
				 * Added By : Mallika.S 01-Apr-2009
				 */
				delegate.codeValidation(code, this);
				getPM_IL_FORMULA_BEAN().setFRM_CODE(code);

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
		finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "FRM_CODE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void deleteRecord() {
		PM_IL_FORMULA_ACTION pm_il_formula_action = new PM_IL_FORMULA_ACTION();
		String rowId = pm_il_formula_action.getPM_IL_FORMULA_BEAN().getROWID();
		delegate.deleteMasterDetails(PM_IL_FORMULA_BEAN);
		PM_IL_FORMULA_BEAN = new PM_IL_FORMULA();
		getWarningMap().put("current", "Record Deleted");
		System.out.println("row ID iS:" + rowId);
		
	}

	ArrayList<SelectItem> listSelect = new ArrayList<SelectItem>();
	ArrayList<String> listSElectDest = new ArrayList<String>();
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				delegate.executeQuery(compositeAction);
				/*compositeAction.getPM_IL_FORMULA_PARAM_ACTION_BEAN().onLoad(null);*/
				listSelect = prepareUserList();
				/*this.listParam = compositeAction.getPM_IL_FORMULA_PARAM_ACTION_BEAN().
				getDataList_PM_IL_FORMULA_PARAM();
				Iterator<PM_IL_FORMULA_PARAM> itr = listParam.iterator();
				while(itr.hasNext()){
					PM_IL_FORMULA_PARAM paramBean = itr.next();
					this.listParam1.add(paramBean.getFP_CAPTION());
				}*/
				setBlockFlag(false);
				
			}
			System.out.println("PM_IL_FORMULA_BEAN.getFRM_FORMULA()------> "+PM_IL_FORMULA_BEAN.getFRM_FORMULA());
			PM_IL_FORMULA_BEAN.setFRM_HIDE(PM_IL_FORMULA_BEAN.getFRM_FORMULA());
			System.out.println("PM_IL_FORMULA_BEAN.getFRM_FORMULA()------>AFTER  "+PM_IL_FORMULA_BEAN.getFRM_HIDE());
			if(PM_IL_FORMULA_BEAN.getFRM_FORMULA()==null)
			{
				System.out.println("Enter sis");
				PM_IL_FORMULA_BEAN.setFRM_HIDE("");	
				PM_IL_FORMULA_BEAN.setFRM_HIDE_TO("");	
			}
			
			
			COMP_FRM_HIDE.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public ArrayList<SelectItem> prepareUserList() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<SelectItem> userList = new ArrayList<SelectItem>();
		SelectItem selectItem = null;
		ResultSet resultSet = null;
		String query = "SELECT FP_CAPTION FROM PM_IL_FORMULA_PARAM ORDER BY 1";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString("FP_CAPTION"));
				selectItem.setLabel(resultSet.getString("FP_CAPTION"));
				userList.add(selectItem);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return userList;
	}

	public String backToSearch() {
		return "PILM204";
	}

	public String formulaDetails() {
		return "formulaDetails";
	}

	public List<PM_IL_FORMULA_PARAM> getListParam() {
		return listParam;
	}

	public void setListParam(List<PM_IL_FORMULA_PARAM> listParam) {
		this.listParam = listParam;
	}

	public List<PM_IL_FORMULA_PARAM> getListParamDestination() {
		return listParamDestination;
	}

	public void setListParamDestination(
			List<PM_IL_FORMULA_PARAM> listParamDestination) {
		this.listParamDestination = listParamDestination;
	}

	public List<String> getListParam1() {
		return listParam1;
	}

	public void setListParam1(List<String> listParam1) {
		this.listParam1 = listParam1;
	}

	public List<String> getListParamDestination1() {
		return listParamDestination1;
	}

	public void setListParamDestination1(List<String> listParamDestination1) {
		this.listParamDestination1 = listParamDestination1;
	}

	public ArrayList<SelectItem> getListSelect() {
		return listSelect;
	}

	public void setListSelect(ArrayList<SelectItem> listSelect) {
		this.listSelect = listSelect;
	}

	public ArrayList<String> getListSElectDest() {
		return listSElectDest;
	}

	public void setListSElectDest(ArrayList<String> listSElectDest) {
		this.listSElectDest = listSElectDest;
	}

	public HtmlPickList getCOMP_UI_PICK() {
		return COMP_UI_PICK;
	}

	public void setCOMP_UI_PICK(HtmlPickList comp_ui_pick) {
		COMP_UI_PICK = comp_ui_pick;
	}
	
	
	
	
	
}