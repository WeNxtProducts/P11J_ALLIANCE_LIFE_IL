package com.iii.pel.forms.PILC_PROP;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.ListItemUtil;

public class PILC_PROP_ACTION  extends CommonReportAction {

	public PILC_PROP_COMPOSITE_ACTION compositeAction;
	private UIData dataTable;
	private List<PILC_PROP> dataList_PILC_PROP = new ArrayList<PILC_PROP>();
	private PILC_PROP PILC_PROP_BEAN;
	
	public PILC_PROP_ACTION()
	{
		PILC_PROP_BEAN = new PILC_PROP();
	}
	 public void onLoad(PhaseEvent event)
	 {
		 if(isBlockFlag())
		 {
			 System.out.println("Welcome to PILC_PROP_COMPOSITE_ACTION");
			 setBlockFlag(false);
		 }
		 
	 }

	public List<PILC_PROP> getDataList_PILC_PROP() {
		return dataList_PILC_PROP;
	}

	public void setDataList_PILC_PROP(List<PILC_PROP> dataList_PILC_PROP) {
		this.dataList_PILC_PROP = dataList_PILC_PROP;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	
	public void postRecord(ActionEvent event) {
		System.out.println("Welcome to Save Method");
	}
	
	private HtmlOutputLabel COMP_PROP_KEY_LABEL;
	private HtmlInputText COMP_PILC_MENU_ACTION;
	private HtmlInputText COMP_PILC_MENU_ACTION_DESC;
	
	public HtmlOutputLabel getCOMP_PROP_KEY_LABEL() {
		return COMP_PROP_KEY_LABEL;
	}

	public void setCOMP_PROP_KEY_LABEL(HtmlOutputLabel cOMP_PROP_KEY_LABEL) {
		COMP_PROP_KEY_LABEL = cOMP_PROP_KEY_LABEL;
	}

	public HtmlInputText getCOMP_PILC_MENU_ACTION() {
		return COMP_PILC_MENU_ACTION;
	}

	public void setCOMP_PILC_MENU_ACTION(HtmlInputText cOMP_PILC_MENU_ACTION) {
		COMP_PILC_MENU_ACTION = cOMP_PILC_MENU_ACTION;
	}

	public PILC_PROP getPILC_PROP_BEAN() {
		return PILC_PROP_BEAN;
	}

	public void setPILC_PROP_BEAN(PILC_PROP pILC_PROP_BEAN) {
		PILC_PROP_BEAN = pILC_PROP_BEAN;
	}


	public HtmlInputText getCOMP_PILC_MENU_ACTION_DESC() {
		return COMP_PILC_MENU_ACTION_DESC;
	}

	public void setCOMP_PILC_MENU_ACTION_DESC(
			HtmlInputText cOMP_PILC_MENU_ACTION_DESC) {
		COMP_PILC_MENU_ACTION_DESC = cOMP_PILC_MENU_ACTION_DESC;
	}

	public ArrayList<LovBean> prepareSuggestionList_EXAM_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*Modifed by Raja on 29/03/2017
		 * 
		 * String query = "SELECT  CONT_CODE,CONT_NAME  FROM   PM_IL_CONTRACTOR WHERE  CONT_EMPLOYER_YN ='Y' "
				+ "AND (CONT_CODE LIKE ? OR CONT_NAME LIKE ?) AND ROWNUM < ?";*/
		
		String query = null;
		 
		query = "SELECT DISTINCT(MENU_ACTION),MENU_SCR_NAME FROM MENU_MENUS WHERE MENU_MODULE_ID = 'IL' AND (MENU_ACTION LIKE ?) AND ROWNUM < ?";

		 
		 
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	public void fetchRecord(ActionEvent event) {
		System.out.println("Welcome to Fetch Method           "+compositeAction.getPILC_PROP_ACTION_BEAN().getPILC_PROP_BEAN().getPILC_MENU_ACTION());
		try
		{
		if(compositeAction.getPILC_PROP_ACTION_BEAN().getPILC_PROP_BEAN().getPILC_MENU_ACTION() != null)
		{
			new PILC_PROP_HELPER().getPropertyFileName(compositeAction);
		}
		}
		catch(Exception e)
		{

			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void PILC_MENU_ACTION_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) {
		System.out.println("Welcome to PILC_MENU_ACTION_WHEN_VALIDATE_ITEM");
		PILC_PROP_BEAN.setPILC_MENU_ACTION((String) value);
	}
}
