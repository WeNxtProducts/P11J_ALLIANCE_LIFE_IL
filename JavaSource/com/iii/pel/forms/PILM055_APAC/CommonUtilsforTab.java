package com.iii.pel.forms.PILM055_APAC;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommonUtilsforTab {
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
						/*if(object == null){
							session.setAttribute(mappedBeanName, this);
						}*/
					}
				}
			}
		}
		
		return object;
	}


}
