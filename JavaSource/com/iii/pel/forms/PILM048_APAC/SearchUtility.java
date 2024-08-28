package com.iii.pel.forms.PILM048_APAC;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SearchUtility {

	public static void clearSession()
	{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION")!=null)
		{
			session.removeAttribute("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
		}
	}
	public static void preBack(){
		// Mapped action bean name for listing bean
		String actionClass = "PLM008_Search";
		// Method which prepares the list
		String actionMethod = "fetchData";
		String returnString = "SearchScreen";
//		CommonUtils commonUtils = new CommonUtils();
		
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();	
		HttpSession session = request.getSession();
		PM_BANK_CHARGE_SETUP_HDRSEARCHACTION actionBean = (PM_BANK_CHARGE_SETUP_HDRSEARCHACTION) session.getAttribute("PILM048_APAC_searchAction");		
//		actionBean.setUpdate(false);
//		actionBean.getPREFORMBUTTON().setDisabled(false);
		
		callRetaintion(actionClass, actionMethod);
	}
	
	public static boolean callRetaintion(String managedBeanName, String methodName){
		FacesContext context = null;
		HttpServletRequest request = null;
		HttpSession session = null;
		Object object = null;
		Class userClass = null;
		Method userMethod = null;
		boolean status = false;
		ExternalContext externalContext = null;
		
		try {
			context = FacesContext.getCurrentInstance();
			if(context != null){
				externalContext = context.getExternalContext();
				if(externalContext != null){
					request = (HttpServletRequest)externalContext.getRequest();
					if(request != null){
						session = request.getSession();
						if(session != null){
							object = session.getAttribute(managedBeanName);
							if(object != null){
								userClass = object.getClass();
								System.out.println("---------->ManagedBeanClass: "+userClass);
								userMethod = userClass.getMethod(methodName, null);
								if(userMethod != null){
									userMethod.invoke(object, null);
									System.out.println("----------->'"+managedBeanName+"."+methodName+"' invoked");
									status = true;
								}else{
									System.out.println("----------->No such method '"+methodName+"' exists in managed bean '"+managedBeanName+"'");
								}
							}else{
								System.out.println("---------->'"+managedBeanName+"' not found in session scope, please check");
							}
						}else{
							System.out.println("---------->Session not found");
						}
					}else{
						System.out.println("---------->Request not found");
					}
				}else{
					System.out.println("---------->ExternalContext not found");
				}
			}else{
				System.out.println("---------->FacesContext not found");
			}
		}catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
}
