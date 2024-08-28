package com.iii.pel.forms.PILM107;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;

public class PM_BANK_HELPER {
	
	public void executeQuery(PILM107_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_BANK_DELEGATE()
		.executeSelectStatement(compositeAction);

		List<PM_BANK> dataList = compositeAction
				.getPM_BANK_ACTION_BEAN().getDataTableList();
		if (dataList != null && dataList.size() > 0) {
			PM_BANK PM_BANK_BEAN = dataList.get(0);
			PM_BANK_BEAN.setRowSelected(true);
			compositeAction.getPM_BANK_ACTION_BEAN().setPM_BANK_BEAN(PM_BANK_BEAN);
			/*Added by ganesh on 26-10-2017, bank issue details */
			compositeAction.getPM_BANK_ACTION_BEAN().disableAllComponents(PM_BANK_BEAN.isUI_M_FREEZE());
			/*end*/
		}
	}


	public void preinsert(PM_BANK_ACTION PM_BANK_ACTION_BEAN,PM_BANK PM_BANK_BEAN)
	{
		try
		{
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			System.out.println("Company Code  == > "+(session.get("GLOBAL.M_COMP_CODE")).toString());
			PM_BANK_BEAN.setBANK_CLIENT_ID((session.get("GLOBAL.M_COMP_CODE")).toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void BANK_PHONE_WHEN_VALIDATE_ITEM(String value)throws Exception{
		try {
		
		int length = value.length();
		String restricting_pattern = "\\d+";
		Pattern p = Pattern.compile(restricting_pattern);
		Matcher  m = p.matcher(value);
		if (!(m.matches())){
			throw new Exception("Value Should be Numeric. ");
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}	
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	public void whenNewCreateInstance(PILM107_COMPOSITE_ACTION compositeAction)throws Exception{
		compositeAction.getPM_BANK_ACTION_BEAN().getCOMP_BANK_FRZ_FLAG_NUM().setSelected(false);
		compositeAction.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().setBANK_FAX_AREA_CODE("+263");
		compositeAction.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().setBANK_MOBILE_AREA_CODE("+263");
		compositeAction.getPM_BANK_ACTION_BEAN().getPM_BANK_BEAN().setBANK_PHONE_AREA_CODE("+263");
		
	}	
	/*end*/
	
}
