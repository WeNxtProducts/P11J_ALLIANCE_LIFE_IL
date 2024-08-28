package com.iii.pel.forms.PM290;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.MailManager.MailCreater;
import com.iii.pel.forms.MailManager.MailVO;
import com.iii.pel.login.util.PasswordSetupUtility;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;




public class PM290_PASSWORD_SETUP_ACTION extends CommonAction{
	private HtmlOutputLabel COMP_USER_NAME_LABEL;
	
	private HtmlInputText COMP_USER_NAME;
	
	private HtmlOutputLabel COMP_OLD_USER_PASSWORD_LABEL;
	
	private HtmlInputSecret COMP_OLD_USER_PASSWORD;
	
	private HtmlOutputLabel COMP_NEW_USER_PASSWORD_LABEL;
	
	private HtmlInputSecret COMP_NEW_USER_PASSWORD;
	
	private HtmlOutputLabel COMP_CONFIRM_NEW_USER_PASSWORD_LABEL;
	
	private HtmlInputSecret COMP_CONFIRM_NEW_USER_PASSWORD;
	
	private HtmlCommandButton COMP_UI_M_BUT_OK;
	
	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;
	
	PM290_PASSWORD_SETUP PASSWORD_SETUP_BEAN;

	PM290_PASSWORD_SETUP_HELPER  helper=new PM290_PASSWORD_SETUP_HELPER();
	
	// Added for password change on expiry
	private HtmlCommandButton COMP_UI_M_BUT_HOME;

	public PM290_PASSWORD_SETUP_ACTION(){
		PASSWORD_SETUP_BEAN=new PM290_PASSWORD_SETUP();	
		helper=new PM290_PASSWORD_SETUP_HELPER();
	}

	public HtmlOutputLabel getCOMP_USER_NAME_LABEL() {
		return COMP_USER_NAME_LABEL;
	}

	public void setCOMP_USER_NAME_LABEL(HtmlOutputLabel comp_user_name_label) {
		COMP_USER_NAME_LABEL = comp_user_name_label;
	}

	public HtmlInputText getCOMP_USER_NAME() {
		return COMP_USER_NAME;
	}

	public void setCOMP_USER_NAME(HtmlInputText comp_user_name) {
		COMP_USER_NAME = comp_user_name;
	}

	public HtmlOutputLabel getCOMP_OLD_USER_PASSWORD_LABEL() {
		return COMP_OLD_USER_PASSWORD_LABEL;
	}

	public void setCOMP_OLD_USER_PASSWORD_LABEL(
			HtmlOutputLabel comp_old_user_password_label) {
		COMP_OLD_USER_PASSWORD_LABEL = comp_old_user_password_label;
	}

	public HtmlInputSecret getCOMP_OLD_USER_PASSWORD() {
		return COMP_OLD_USER_PASSWORD;
	}

	public void setCOMP_OLD_USER_PASSWORD(HtmlInputSecret comp_old_user_password) {
		COMP_OLD_USER_PASSWORD = comp_old_user_password;
	}

	public HtmlOutputLabel getCOMP_NEW_USER_PASSWORD_LABEL() {
		return COMP_NEW_USER_PASSWORD_LABEL;
	}

	public void setCOMP_NEW_USER_PASSWORD_LABEL(
			HtmlOutputLabel comp_new_user_password_label) {
		COMP_NEW_USER_PASSWORD_LABEL = comp_new_user_password_label;
	}

	public HtmlInputSecret getCOMP_NEW_USER_PASSWORD() {
		return COMP_NEW_USER_PASSWORD;
	}

	public void setCOMP_NEW_USER_PASSWORD(HtmlInputSecret comp_new_user_password) {
		COMP_NEW_USER_PASSWORD = comp_new_user_password;
	}

	public HtmlOutputLabel getCOMP_CONFIRM_NEW_USER_PASSWORD_LABEL() {
		return COMP_CONFIRM_NEW_USER_PASSWORD_LABEL;
	}

	public void setCOMP_CONFIRM_NEW_USER_PASSWORD_LABEL(
			HtmlOutputLabel comp_confirm_new_user_password_label) {
		COMP_CONFIRM_NEW_USER_PASSWORD_LABEL = comp_confirm_new_user_password_label;
	}

	public HtmlInputSecret getCOMP_CONFIRM_NEW_USER_PASSWORD() {
		return COMP_CONFIRM_NEW_USER_PASSWORD;
	}

	public void setCOMP_CONFIRM_NEW_USER_PASSWORD(
			HtmlInputSecret comp_confirm_new_user_password) {
		COMP_CONFIRM_NEW_USER_PASSWORD = comp_confirm_new_user_password;
	}

	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			PASSWORD_SETUP_BEAN.setUSER_NAME(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			
			// Disable the goto home button 
			// Since the button COMP_UI_M_BUT_HOME is applicable only for change password on expiry, 
			//	null check is required
			/*if(COMP_UI_M_BUT_HOME != null){
				COMP_UI_M_BUT_HOME.setDisabled(true);
			}
			*/
			setBlockFlag(false);
		}
	}
	
	public void whenValidateOLD_USER_PASSWORD(ActionEvent actionEvent){
		String oldPassword = null;
		
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		oldPassword = (String) input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
		//if(input.isValid()){
			PASSWORD_SETUP_BEAN.setOLD_USER_PASSWORD(oldPassword);
		//}
	}
	
	public void validator_OLD_USER_PASSWORD(FacesContext facesContext,UIComponent component, Object value) throws ValidatorException {
		String currentPassword = (String) value;

		try {
			if(currentPassword!=null){
				helper.validateCurrentPassword(this, currentPassword);
			}
			//COMP_NEW_USER_PASSWORD.resetValue();
			//COMP_CONFIRM_NEW_USER_PASSWORD.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}	
	
	public void whenValidateNEW_USER_PASSWORD(ActionEvent actionEvent){
		String newPassword = null;
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		newPassword = (String) input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
		//if(input.isValid()){
			PASSWORD_SETUP_BEAN.setNEW_USER_PASSWORD(newPassword);
		//}
	}
	
	public void validator_NEW_USER_PASSWORD(FacesContext facesContext,UIComponent component, Object value) throws ValidatorException {
		String newPassword = (String) value;

		try {
			if(newPassword!=null){
				
				/*added by raja on 10-06-2017 for ZBILQC-1728894*/ 
				USER_PASSWORD_WHEN_VALIDATE_ITEM(newPassword);
				/*end*/
				/*added by raja on 10-06-2017 for ZBILQC-1718815*/ 
				passwordReuseValidation(newPassword);
				/*end*/
				helper.validateNewPassword(this, newPassword);
			}
			//COMP_CONFIRM_NEW_USER_PASSWORD.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}	
	
	public void whenValidateCONFIRM_NEW_USER_PASSWORD(ActionEvent actionEvent){
		String confirmPassword = null;
		
		CommonUtils.clearMaps(this);
		UIInput input=(UIInput) actionEvent.getComponent().getParent();
		confirmPassword = (String) input.getSubmittedValue();
		ErrorHelpUtil.validate(input, getErrorMap());
		//if(input.isValid()){
			PASSWORD_SETUP_BEAN.setCONFIRM_NEW_USER_PASSWORD(confirmPassword);
		//}
	}

	
	public void validator_CONFIRM_NEW_USER_PASSWORD(FacesContext facesContext,UIComponent component, Object value) throws ValidatorException {
		String confirmPassword = (String) value;
		
		try {
			if(confirmPassword!=null){
				helper.validateConfirmNewPassword(this, confirmPassword);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}	
	
	public PM290_PASSWORD_SETUP getPASSWORD_SETUP_BEAN() {
		return PASSWORD_SETUP_BEAN;
	}

	public void setPASSWORD_SETUP_BEAN(PM290_PASSWORD_SETUP password_setup_bean) {
		PASSWORD_SETUP_BEAN = password_setup_bean;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton comp_ui_m_but_cancel) {
		COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}
	
	public String actionOnCancelClick(){
		 return "";
	}
	
	public String actionOnOkClick(){

		CommonUtils.clearMaps(this);
		try {
			//update menu_user WITH PASSWORD AND EXP DATE
			helper.updateData(PASSWORD_SETUP_BEAN);
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Password Updated successfully for "+PASSWORD_SETUP_BEAN.getUSER_NAME());
			/* MailVO mobj  = mailtTemp(PASSWORD_SETUP_BEAN.getUSER_NAME());
				
				MailCreater mcreate = new MailCreater();

					mcreate.sendMail(mobj);*/
			getWarningMap().put("OK", "Password Updated successfully for "+PASSWORD_SETUP_BEAN.getUSER_NAME()+"For more Detatil Please Check Your Mail");
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("OK", e.getMessage());
		}
		return "";
	}
	
	
	
	
	

public MailVO mailtTemp(String User_id)throws Exception
{
System.out.println("***************entering into mailtemp**************");
	String query = "SELECT PMT_MAIL_FM,PMT_MAIL_SUB ,PMT_MAIL_TEXT from PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE='F'";
	String Mquere ="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_ID= ?";
	ResultSet rst = null;
	ResultSet rst1 = null;
	CRUDHandler handler = new CRUDHandler();
	Connection connection = (Connection) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("CONNECTION.LOGIN");
	MailVO mobj = new MailVO();
	List<String> ToList= new ArrayList<String>();


	try {
		
		rst1 = handler.executeSelectStatement(Mquere,connection,new Object[]{User_id});
		if(rst1.next()) {
			System.out.println("rst1.getString(USER_EMAIL_ID)"+rst1.getString("USER_EMAIL_ID"));
			if(rst1.getString("USER_EMAIL_ID")!=null){
			ToList.add(rst1.getString("USER_EMAIL_ID"));
			}
		}
		
	} catch (Exception e) {
		throw new Exception();
	} finally {
		try {
			CommonUtils.closeCursor(rst1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		mobj.setToList(ToList);
			try {
			
				rst = handler.executeSelectStatement(query,connection);
				while (rst.next()) {
					mobj.setFromId(rst.getString("PMT_MAIL_FM"));
					mobj.setSubject(rst.getString("PMT_MAIL_SUB"));
					 mobj.setMessageBody(rst.getString("PMT_MAIL_TEXT"));
				}
			} catch (Exception e) {
				throw new Exception();
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			

return mobj;

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String changePassword(){
		CommonUtils.clearMaps(this);
		
		try {
			// Update menu_user WITH PASSWORD AND EXP DATE
			helper.updateData(PASSWORD_SETUP_BEAN);
			
			// Enable the goto home button and disable the rest
			COMP_UI_M_BUT_HOME.setDisabled(false);
			COMP_OLD_USER_PASSWORD.setDisabled(true);
			COMP_NEW_USER_PASSWORD.setDisabled(true);
			COMP_CONFIRM_NEW_USER_PASSWORD.setDisabled(true);
			COMP_UI_M_BUT_OK.setDisabled(true);
			
			/*Changed by Ram on 08/11/2016 for FALCONLIFE-1353188*/
			//getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Password Updated successfully for "+PASSWORD_SETUP_BEAN.getUSER_NAME()+"For more Detatil Please Check Your Mail");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,"Password Updated successfully for "+PASSWORD_SETUP_BEAN.getUSER_NAME()+"Please Login and Continue");
			/*End*/
			
			/*
			 MailVO mobj  = mailtTemp(PASSWORD_SETUP_BEAN.getUSER_NAME());
				
				MailCreater mcreate = new MailCreater();

					mcreate.sendMail(mobj);*/
			getWarningMap().put("OK", "Password Updated successfully for "+PASSWORD_SETUP_BEAN.getUSER_NAME());
			/*Added by ganesh on 15-02-2018 to display message for change password*/
			
			/*Modified by Janani on 03.05.2018 as required by Vinoth for changing Password success msg in green color*/ 
			
			/*PasswordSetupUtility
			.setPASS_EXP_MESSAGE_InSession("Your Password has been changed Successfully");*/
			
			PasswordSetupUtility
			.setPASS_SUCC_MESSAGE_InSession("Your Password has been changed Successfully");
			
			/*End*/
			
			CommonUtils.setGlobalVariable("PWD_CHG_YN","Y");
			/*end*/
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("OK", e.getMessage());
		}
		
		 
		return "premia-home";
		 
	}
	
	/*Changed by Ram on 10/11/2016 for FALCONLIFE-1353188*/
	public String gotoHome(){
		String outcome = "premia-home";
		getPASSWORD_SETUP_BEAN().setOLD_USER_PASSWORD(null);
		getPASSWORD_SETUP_BEAN().setNEW_USER_PASSWORD(null);
		getPASSWORD_SETUP_BEAN().setCONFIRM_NEW_USER_PASSWORD(null);
		
		getCOMP_OLD_USER_PASSWORD().resetValue();
		getCOMP_NEW_USER_PASSWORD().resetValue();
		getCOMP_CONFIRM_NEW_USER_PASSWORD().resetValue();
		
		return outcome;
	}
/*End*/
	public HtmlCommandButton getCOMP_UI_M_BUT_HOME() {
		return COMP_UI_M_BUT_HOME;
	}
	public void setCOMP_UI_M_BUT_HOME(HtmlCommandButton comp_ui_m_but_home) {
		COMP_UI_M_BUT_HOME = comp_ui_m_but_home;
	}
	
	/*added by raja on 10-06-2017 for ZBILQC-1728894*/ 
	public void USER_PASSWORD_WHEN_VALIDATE_ITEM(String password) throws Exception {
	    boolean isCap = false;
	    boolean symbol = false;
	    boolean number = false;
	    boolean isLower = false;
	    int count = 0;
	    if (password != null)
	    {
	      if (password.length() < 8)
	      {
	        throw new Exception("Password should contains atleast 8 character");
	      }

	      for (int i = 0; i < password.length(); i++) {
	        isCap = isCapsAvalable(password.charAt(i));
	        if (isCap)
	        {
	          break;
	        }
	      }
	      
	      /*added by raja on 10-06-2017 for ZBILQC-1728894*/ 
	      for (int i = 0; i < password.length(); i++) {
		        isLower = isLowercaseAvalable(password.charAt(i));
		        if (isLower)
		        {
		          break;
		        }
		      }
	      if(!isLower)
	      {
	    	  count++;
	      }
	      
	      /*END*/
	      if (!isCap)
	      {
	    	  /*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
	        count++;
	       /* getErrorMap().put("current", 
	                "Password should contains atleast one capital letter");
	              getErrorMap().put("current", "Password should contains atleast one capital letter");
	              getErrorMap().put("details", "Password should contains atleast one capital letter");*/
	        /*end*/
	      }
	      /*added by R. Raja on 14-12-2016 for RM018T - FSD_IL_ZB Life_030_PREMIA Security*/
	      if ((symbol = isSymbol(password)))
	      {
	        count++;
	      }

	      for (int i = 0; i < password.length(); i++) {
	        number = isNumeric(password.charAt(i));
	        if (number)
	        {
	          break;
	        }
	      }
	      if (!number)
	      {
	        count++;
	      }
	    }
	    System.out.println("count is =====" + count);
	    if (count >= 2)
	    {
	      throw new Exception("Password should contains atleast one capital letter and one numeric letter and one special character");
	    }
	  }

	  private boolean isCapsAvalable(char c)
	  {
	    boolean result = false;
	    if ((c >= 'A') && (c <= 'Z')) {
	      result = true;
	    }
	    return result;
	  }

	  private boolean isSymbol(String password)
	  {
	    boolean symbol = false;
	    Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
	    Matcher matcher = pattern.matcher(password);
	    if (matcher.matches()) {
	      symbol = true;
	    }
	    return symbol;
	  }

	  private boolean isNumeric(char c)
	  {
	    boolean symbol = false;

	    if (Character.isDigit(c))
	      symbol = true;
	    return symbol;
	  }
	  
	  /*added by raja on 10-06-2017 for ZBILQC-1728894*/ 
	  private boolean isLowercaseAvalable(char c)
	  {
	    boolean result = false;
	    if ((c >= 'a') && (c <= 'z')) {
	      result = true;
	    }
	    return result;
	  }
	  /*END*/
	  
	  /*end*/
	  /*added by raja on 10-06-2017 for ZBILQC-1718815*/
	  public void passwordReuseValidation(String currentPass) throws Exception
	  {
		  try
		  {
			  int recordCount=0;
			  String passwordHistoryCount="select USER_PWD_REUSE_COUNT from MENU_USER WHERE USER_ID=?";
			  String passwordHistoryQuery="select decrypt(UPH_PWD,'3iInfotech') from  USER_PWD_HISTORY where uph_user_id=? order by UPH_SYS_ID desc";
		  String password=null;
			ResultSet passHistRS=new CRUDHandler().executeSelectStatement(passwordHistoryQuery, 
					CommonUtils.getConnection(), new Object[]{PASSWORD_SETUP_BEAN.getUSER_NAME()});
			
			ResultSet resultSet2=new CRUDHandler().executeSelectStatement(passwordHistoryCount, 
					CommonUtils.getConnection(),
					new Object[]{PASSWORD_SETUP_BEAN.getUSER_NAME()});
			while(resultSet2.next()){
				/*recordCount++;*/
				recordCount=resultSet2.getInt("USER_PWD_REUSE_COUNT");
			}
			
			
			for(int i=0;passHistRS.next() && i<recordCount;i++)
			{
				if(currentPass.equalsIgnoreCase(passHistRS.getString(1)))
					
				{
					throw new Exception("Cannot use this password");
				}
			}
		  }catch(Exception e)
		  {
			  e.printStackTrace();
			  throw e;
		  }
	  }
	  /*end*/
}
