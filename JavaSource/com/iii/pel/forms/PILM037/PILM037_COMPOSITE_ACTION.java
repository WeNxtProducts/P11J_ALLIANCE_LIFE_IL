package com.iii.pel.forms.PILM037;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PILM037_COMPOSITE_ACTION {
	
	SearchAction searchActionBean; 
	PM_IL_BONUS_SETUP_ACTION PM_IL_BONUS_SETUP_ACTION_BEAN;
	COPY_ACTION COPY_ACTION_BEAN;
	public PILM037_Helper helper ;
	

	public PILM037_COMPOSITE_ACTION() {
		searchActionBean = new SearchAction();
		PM_IL_BONUS_SETUP_ACTION_BEAN = new PM_IL_BONUS_SETUP_ACTION();
		COPY_ACTION_BEAN = new COPY_ACTION();
		
		PM_IL_BONUS_SETUP_ACTION_BEAN.compositeAction = this;
		COPY_ACTION_BEAN.compositeAction = this;
		helper = new PILM037_Helper();
		helper.setAction(PM_IL_BONUS_SETUP_ACTION_BEAN);
	}


	public SearchAction getSearchActionBean() {
		return searchActionBean;
	}


	public void setSearchActionBean(SearchAction searchActionBean) {
		this.searchActionBean = searchActionBean;
	}


	public PM_IL_BONUS_SETUP_ACTION getPM_IL_BONUS_SETUP_ACTION_BEAN() {
		return PM_IL_BONUS_SETUP_ACTION_BEAN;
	}


	public void setPM_IL_BONUS_SETUP_ACTION_BEAN(
			PM_IL_BONUS_SETUP_ACTION pm_il_bonus_setup_action_bean) {
		PM_IL_BONUS_SETUP_ACTION_BEAN = pm_il_bonus_setup_action_bean;
	}


	public COPY_ACTION getCOPY_ACTION_BEAN() {
		return COPY_ACTION_BEAN;
	}


	public void setCOPY_ACTION_BEAN(COPY_ACTION copy_action_bean) {
		COPY_ACTION_BEAN = copy_action_bean;
	}
	
	public Object getMappedBeanFromSession(String mappedBeanName){
		Object object = null;
		ExternalContext externalContext =null;
		HttpServletRequest request=null;
		HttpSession session=null;
		FacesContext context = null;

		context =FacesContext.getCurrentInstance();
		if(context != null){
			externalContext = context.getExternalContext();
			if (externalContext != null) {
				request = (HttpServletRequest) externalContext.getRequest();
				if (request != null) {
					session = request.getSession();
					if (session != null) {
						object = session.getAttribute(mappedBeanName);
						System.out
								.println("PILM037_COMPOSITE_ACTION.getMappedBeanFromSession()"+object);
						if(object == null){
							session.setAttribute(mappedBeanName, this);
						}
					}
				}
			}
		}
		
		return object;
	}

	
	

}
