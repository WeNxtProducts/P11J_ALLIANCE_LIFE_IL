package com.iii.pel.forms.PILM034;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.premia.common.commonimpl.tabimpl.TabItem;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
public class PILM034_COMPOSITE_ACTION{
	public final static int TAB_PM_IL_TAR_PARAM = 1;
	public final static int TAB_PM_IL_TAR_HDR = 3;
	private TabbedBar tabbedBar ;
	private PM_IL_TAR_PARAM_ACTION PM_IL_TAR_PARAM_ACTION_BEAN ;
	private PP_LIST_ITEM_VALUES_ACTION PP_LIST_ITEM_VALUES_ACTION_BEAN ;
	private PM_IL_TAR_HDR_ACTION PM_IL_TAR_HDR_ACTION_BEAN ;
	private PM_IL_TAR_DTL_ACTION PM_IL_TAR_DTL_ACTION_BEAN ;
	private PM_IL_TAR_DTL_DUMMY PM_IL_TAR_DTL_DUMMY_BEAN;
	private BP_ACTION BP_ACTION_BEAN ;
	public String callPM_IL_TAR_PARAM(){
		preTabClick();
		return "PILM034_PM_IL_TAR_PARAM";

	}
	public String callPP_LIST_ITEM_VALUES(){
		preTabClick();
		return "PILM034_PP_LIST_ITEM_VALUES";

	}
	public String callPM_IL_TAR_HDR(){
		preTabClick();
		return "PILM034_PM_IL_TAR_HDR";

	}
	public String navigationEnabled(){
		setImmediate(true);
		return "";

	}
	private void setImmediate(boolean flag){
		ArrayList<TabItem> tabItemList = tabbedBar.getTabList();
		Iterator<TabItem> tabIterator = tabItemList.iterator();
		while (tabIterator.hasNext()) {
			TabItem item = tabIterator.next();
			item.setImmediate(flag);
		}
	}
	private void preTabClick(){
		int currentTabId = tabbedBar.getCurrentTabId();
		switch(currentTabId){
		case 1 :PM_IL_TAR_PARAM_ACTION_BEAN.setBlockFlag(true);
		setImmediate(false);
		break;
		case 3 :PM_IL_TAR_HDR_ACTION_BEAN.setBlockFlag(true);
		setImmediate(false);
		break;
		case 4 :PM_IL_TAR_DTL_ACTION_BEAN.setBlockFlag(true);
		setImmediate(false);
		break;
		}
	}
	public void setTabbedBar(TabbedBar tabbedBar){
		this.tabbedBar=tabbedBar;

	}
	public TabbedBar getTabbedBar(){
		return this.tabbedBar;

	}
	public void setPM_IL_TAR_PARAM_ACTION_BEAN(PM_IL_TAR_PARAM_ACTION PM_IL_TAR_PARAM_ACTION_BEAN){
		this.PM_IL_TAR_PARAM_ACTION_BEAN=PM_IL_TAR_PARAM_ACTION_BEAN;

	}
	public PM_IL_TAR_PARAM_ACTION getPM_IL_TAR_PARAM_ACTION_BEAN(){
		return this.PM_IL_TAR_PARAM_ACTION_BEAN;

	}
	public void setPP_LIST_ITEM_VALUES_ACTION_BEAN(PP_LIST_ITEM_VALUES_ACTION PP_LIST_ITEM_VALUES_ACTION_BEAN){
		this.PP_LIST_ITEM_VALUES_ACTION_BEAN=PP_LIST_ITEM_VALUES_ACTION_BEAN;

	}
	public PP_LIST_ITEM_VALUES_ACTION getPP_LIST_ITEM_VALUES_ACTION_BEAN(){
		return this.PP_LIST_ITEM_VALUES_ACTION_BEAN;

	}
	public void setPM_IL_TAR_HDR_ACTION_BEAN(PM_IL_TAR_HDR_ACTION PM_IL_TAR_HDR_ACTION_BEAN){
		this.PM_IL_TAR_HDR_ACTION_BEAN=PM_IL_TAR_HDR_ACTION_BEAN;

	}
	public PM_IL_TAR_HDR_ACTION getPM_IL_TAR_HDR_ACTION_BEAN(){
		return this.PM_IL_TAR_HDR_ACTION_BEAN;

	}
	public void setPM_IL_TAR_DTL_ACTION_BEAN(PM_IL_TAR_DTL_ACTION PM_IL_TAR_DTL_ACTION_BEAN){
		this.PM_IL_TAR_DTL_ACTION_BEAN=PM_IL_TAR_DTL_ACTION_BEAN;

	}
	public PM_IL_TAR_DTL_ACTION getPM_IL_TAR_DTL_ACTION_BEAN(){
		return this.PM_IL_TAR_DTL_ACTION_BEAN;

	}
	public void setBP_ACTION_BEAN(BP_ACTION BP_ACTION_BEAN){
		this.BP_ACTION_BEAN=BP_ACTION_BEAN;

	}
	public BP_ACTION getBP_ACTION_BEAN(){
		return this.BP_ACTION_BEAN;

	}
	public PILM034_COMPOSITE_ACTION(){
		tabbedBar = new TabbedBar();
		PM_IL_TAR_PARAM_ACTION_BEAN = new PM_IL_TAR_PARAM_ACTION();
		PP_LIST_ITEM_VALUES_ACTION_BEAN = new PP_LIST_ITEM_VALUES_ACTION();
		PM_IL_TAR_HDR_ACTION_BEAN = new PM_IL_TAR_HDR_ACTION();
		PM_IL_TAR_DTL_ACTION_BEAN = new PM_IL_TAR_DTL_ACTION();
		PM_IL_TAR_DTL_DUMMY_BEAN = new PM_IL_TAR_DTL_DUMMY();
		BP_ACTION_BEAN = new BP_ACTION();
		PM_IL_TAR_PARAM_ACTION_BEAN.compositeAction = this;
		PP_LIST_ITEM_VALUES_ACTION_BEAN.compositeAction = this;
		PM_IL_TAR_HDR_ACTION_BEAN.compositeAction = this;
		PM_IL_TAR_DTL_ACTION_BEAN.compositeAction = this;
		BP_ACTION_BEAN.compositeAction = this;
		try{
			tabbedBar.addTab(TAB_PM_IL_TAR_PARAM, "#{PILM034_COMPOSITE_ACTION.callPM_IL_TAR_PARAM}", 
					Messages.getString("messageProperties_PILM034", 
							"PILM034$PM_IL_TAR_PARAM$displayCaption"), false);
			tabbedBar.addTab(TAB_PM_IL_TAR_HDR, "#{PILM034_COMPOSITE_ACTION.callPM_IL_TAR_HDR}", 
					Messages.getString("messageProperties_PILM034", 
							"PILM034$PM_IL_TAR_HDR$displayCaption"), false);
		}
		catch(Exception exc){
			PM_IL_TAR_PARAM_ACTION_BEAN.getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
			PM_IL_TAR_PARAM_ACTION_BEAN.getErrorMap().put("PILM034_COMPOSITE_ACTION",exc.getMessage());
		}

	}
	public PM_IL_TAR_DTL_DUMMY getPM_IL_TAR_DTL_DUMMY_BEAN() {
		return PM_IL_TAR_DTL_DUMMY_BEAN;
	}
	public void setPM_IL_TAR_DTL_DUMMY_BEAN(
			PM_IL_TAR_DTL_DUMMY pm_il_tar_dtl_dummy_bean) {
		PM_IL_TAR_DTL_DUMMY_BEAN = pm_il_tar_dtl_dummy_bean;
	}

}
