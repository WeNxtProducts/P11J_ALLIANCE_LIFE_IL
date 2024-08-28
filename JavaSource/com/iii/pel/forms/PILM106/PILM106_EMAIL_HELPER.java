package com.iii.pel.forms.PILM106;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.runtime.functions.ConvertFunctions;

public class PILM106_EMAIL_HELPER {
	
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	
	
	public void executeSelectStatement(PILM106_EMAIL_COMPOSITE_ACTION compositeAction,String product) throws Exception
	{
		
		System.out.println("PILM106_EMAIL_HELPER+executeSelectStatement"+compositeAction);
		 new PILM106_EMAIL_DELEGATE().executeSelectStatement(compositeAction,product);
	}
	
	public void executeQuery(PILM106_EMAIL_COMPOSITE_ACTION compositeAction)
			throws Exception {
		System.out.println("helper execute");
		new PILM106_EMAIL_DELEGATE().executeLoadData(compositeAction);
	}
	

	
	
	
		public void FromIDValidator(PILM106_EMAIL_BEAN headerBean) throws Exception{
    	String FROMID = headerBean.getPMT_MAIL_FM();
    	pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(FROMID);
		boolean flag= matcher.matches();
    	 
    	    
    		
    	
    	try {
    		if(!flag){
    			throw new Exception("invalied email");
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }
	
	public void effectivFromDateValidator(PILM106_EMAIL_BEAN headerBean) throws Exception{
    	Date MAil_EFF_TO_DT = headerBean.getPMT_EFF_TO_DT();
    	Date MAIL_EFF_FM_DT = headerBean.getPMT_EFF_FM_DT();
    	try {
    		if(MAil_EFF_TO_DT!=null && MAil_EFF_TO_DT.before(MAIL_EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(MAIL_EFF_FM_DT!=null && MAIL_EFF_FM_DT.before(ConvertFunctions.to_date("01/01/1900", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }
    
    public void effectiveToDateValidator(PILM106_EMAIL_BEAN headerBean) throws Exception {
    	Date MAil_EFF_TO_DT = headerBean.getPMT_EFF_TO_DT();
    	Date MAIL_EFF_FM_DT = headerBean.getPMT_EFF_FM_DT();
    	try {
    		if(MAIL_EFF_FM_DT !=null){
    			
    		if(MAil_EFF_TO_DT.before(MAIL_EFF_FM_DT)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
    		}
    		if(MAil_EFF_TO_DT.after(ConvertFunctions.to_date("31/12/2999", PELConstants.dbDateFormat))){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91255"));
    		}
    		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
    }
	
    
    
    
    
	
}
