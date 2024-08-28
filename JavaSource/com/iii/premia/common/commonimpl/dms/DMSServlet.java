package com.iii.premia.common.commonimpl.dms;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class DMSServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   private Lifecycle lifecycle = null;
   private FacesContext context = null;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getServletContext().getRequestDispatcher("HomeAction").forward(request, response);/jsf/login/home.xhtml
		DMSHelper helper = new DMSHelper();
		
		try{
			getFacesContext(request, response);
			helper.processRequest(request);
			performLifecycle();
			response.sendRedirect("http://10.44.0.138:8082/p11jindlife/jsf/PILT002_APAC/PILT002_APAC_PT_IL_POLICY.xhtml");//getServletContext().getRequestDispatcher("/jsf/PILT002_APAC/PILT002_APAC_PT_IL_POLICY.xhtml").forward(request, response);
		}catch(Exception exc){
			exc.printStackTrace();
			getServletContext().getRequestDispatcher("/jsf/login/login.jsf").forward(request, response);
			//getServletContext().getRequestDispatcher("/jsf/login/home.xhtml").forward(request, response);
		}
	}
	
	
	protected FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse
			response) {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext == null) {
	        FacesContextFactory contextFactory  =
				(FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
	        LifecycleFactory lifecycleFactory =
				(LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
			Lifecycle lifecycle =
				lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);
				
			facesContext = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response,
				lifecycle);
			context = facesContext;
			this.lifecycle = lifecycle;
				
			// Set using our inner class
			InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);
				
			// set a new viewRoot, otherwise context.getViewRoot returns null
			UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "_viewRoot");
			facesContext.setViewRoot(view);
		}
        
        return facesContext;
	}
	
	public void performLifecycle(){
		try
        {
            lifecycle.execute(context);
            //lifecycle.render(context);
        }
        catch(FacesException e)
        {
        	e.printStackTrace();
            /*Throwable t = e.getCause();
            if(t == null)
                throw new ServletException(e.getMessage(), e);
            if(t instanceof ServletException)
                throw (ServletException)t;
            if(t instanceof IOException)
                throw (IOException)t;
            else
                throw new ServletException(t.getMessage(), t);*/
        }
        finally
        {
        	context.release();
        }
        //context.release();
	}
		
	/*protected Object getBean(String beanName, FacesContext facesContext) {
		return getApplication(facesContext).getVariableResolver().resolveVariable(facesContext,	beanName);
	}*/

	// You need an inner class to be able to call FacesContext.setCurrentInstance
	// since it's a protected method
	private abstract static class InnerFacesContext extends FacesContext {
	    protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
	        FacesContext.setCurrentInstance(facesContext);
	    }
	}
}
