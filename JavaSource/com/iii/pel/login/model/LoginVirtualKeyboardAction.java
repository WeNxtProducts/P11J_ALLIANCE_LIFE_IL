package com.iii.pel.login.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.iii.pel.login.constant.LangConstants;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;

public class LoginVirtualKeyboardAction extends CommonAction  {
	
	private HtmlOutputLabel COMP_UI_B_CHECK_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_CHECK;
	
	private HtmlPanelGrid COMP_VIRTUAL_GRID;
	
	private HtmlPanelGrid COMP_ALPHABET_GRID;
	
	private HtmlPanelGrid COMP_NUMERIC_GRID;
	
	private HtmlPanelGrid COMP_SPLKEYS_GRID;
	
	private LoginVirtualKeyboardBean loginVirtualKeyboardBean;
	
	private ArrayList<String> alphabetCharsList = new ArrayList<String>();
	
	private ArrayList<String> splCharsList = new ArrayList<String>();
	
	private ArrayList<String> numericCharsList = new ArrayList<String>();
	
	private LangConstants langConst;
	
	private LoginDelegate loginDelegateBean;
	
	
	
	public LoginDelegate getLoginDelegateBean() {
		return loginDelegateBean;
	}

	public void setLoginDelegateBean(LoginDelegate loginDelegateBean) {
		this.loginDelegateBean = loginDelegateBean;
	}

	public LoginVirtualKeyboardAction() {
		loginVirtualKeyboardBean = new LoginVirtualKeyboardBean();
		langConst = new LangConstants();
		loginDelegateBean = new LoginDelegate();
		// Preparing virtual key lists
		prepareVirtualKeyLists();
		
		// Shuffling virtual key list
		shuffleVirtualKeyLists();
	}
	
	private void prepareVirtualKeyLists(){
		String[] values = null;
		final String VALUE_SEPARATOR = ",";
		
		// Preparing alphabets list
		values = Messages.getString("login", "premia_virtual_keyboard_alphabets").split(VALUE_SEPARATOR);
		for(int index=0, size=values.length; index<size; index++){
			alphabetCharsList.add(values[index]);
		}
		
		// Preparing special characters list
		values = Messages.getString("login", "premia_virtual_keyboard_special_characters").split(VALUE_SEPARATOR);
		for(int index=0, size=values.length; index<size; index++){
			splCharsList.add(values[index]);
		}
		
		// Preparing numbers list
		values = Messages.getString("login", "premia_virtual_keyboard_numeric_characters").split(VALUE_SEPARATOR);
		for(int index=0, size=values.length; index<size; index++){
			numericCharsList.add(values[index]);
		}
	}
	
	private void shuffleAndAssignVirtualKeyValues(){
		// Shuffling virtual key values
		shuffleVirtualKeyLists();
		
		// Assigning shuffled values to virtual keys
		assignVirtualKeyValues(COMP_ALPHABET_GRID, alphabetCharsList);
		assignVirtualKeyValues(COMP_SPLKEYS_GRID, splCharsList);
		assignVirtualKeyValues(COMP_NUMERIC_GRID, numericCharsList);
	}
	
	private void shuffleVirtualKeyLists(){
		Collections.shuffle(alphabetCharsList);
		Collections.shuffle(splCharsList);
		Collections.shuffle(numericCharsList);
	}
	
	private void assignVirtualKeyValues(UIComponent component, ArrayList<String> keyValues){
		int index = 0;
		
		if(component != null){
			for(UIComponent child: component.getChildren()){
				if(child instanceof HtmlCommandButton){
					((HtmlCommandButton)child).setValue(keyValues.get(index++));
				}
			}
		}
	}
	
	public void beforePhase(PhaseEvent event){
		
		try {
			if(isBlockFlag()){
				disableAllChildButtons(COMP_VIRTUAL_GRID, true);
				
				// Shuffling and assigning values to virtual key board
				shuffleAndAssignVirtualKeyValues();
				
				/*Added by Gopi on 5/3/2016 for CompanyCode defaul(Start)*/
				setDefaultCompanyCode();
				/*End*/
				
				/*Added by Raja on 05/04/2017 for Password Reset concept*/
				LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext.getCurrentInstance()
						.getExternalContext().getSessionMap().get("loginManagedBean");
				


loginManagedBean.getResetpasswordButton().setStyle("display:none");
loginManagedBean.getCOMP_RESET_PASSWORD_MODAL_PANEL().setShowWhenRendered(false);

				/*if(loginManagedBean.getExpiry_YN() != null && loginManagedBean.getExpiry_YN().equals("Y"))
				{
					loginManagedBean.getResetpasswordButton().setRendered(true);
						
				}
				else
				{
					loginManagedBean.getResetpasswordButton().setRendered(false);
					
				}*/
				/*End*/

vcard_image();


				setBlockFlag(false);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	/*Added by Gopi on 5/3/2016 for CompanyCode defaul(Start)*/
	private VcardAction vcardAction;
	
	
	
	public VcardAction getVcardAction() {
		return vcardAction;
	}

	public void setVcardAction(VcardAction vcardAction) {
		this.vcardAction = vcardAction;
	}

	public void setDefaultCompanyCode() throws Exception
	{
		System.out.println("i m here");
		vcardAction = new VcardAction();
		
		LoginManagedBean loginManagedBean = (LoginManagedBean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("loginManagedBean");
		System.out.println("loginManagedBean         "+loginManagedBean);
	   String companycode= new LoginDelegate().executeSelectStatement();
	    loginManagedBean.getLoginBean().setCompanyCode(companycode);
			
		if(companycode != null)
		{
			loginManagedBean.getCompanyCodeBox().setDisabled(false);
		}
	}
	/*end*/
	

	/*public void intiantiateAllComp(){
		
	}*/
	public void validateCheck(ActionEvent actionEvent) {
		LoginManagedBean loginManagedBean = null;		
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		Boolean  value = (Boolean) input.getSubmittedValue();
		Boolean booleanValue = Boolean.valueOf(value);

		try {
			loginManagedBean = (LoginManagedBean) FacesContext
				.getCurrentInstance().getExternalContext()
				.getSessionMap().get("loginManagedBean");
			
			if (value) {
				loginVirtualKeyboardBean.setCheck(booleanValue);
				loginManagedBean.getLoginBean().setPassword(null);
				loginManagedBean.getPassword().resetValue();
				// Making password field readonly
				//loginManagedBean.getPassword().setReadonly(true);
				// Enabling all buttons
				disableAllChildButtons(this.COMP_VIRTUAL_GRID, false);
			} else {
				loginVirtualKeyboardBean.setCheck(booleanValue);
				// Disabling all buttons
				disableAllChildButtons(this.COMP_VIRTUAL_GRID, true);
				// Making password field readonly
				//loginManagedBean.getPassword().setReadonly(false);
			}
		} catch (Exception e) {
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
			loginManagedBean.getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			loginManagedBean.getErrorMap().put("VALIDATE_CHECKBOX", e.getMessage());
		}
	}
	
	public void disableAllChildButtons(UIComponent component, boolean disable) throws Exception{
		try{
			if(component != null){
				for(UIComponent child: component.getChildren()){
					if(child instanceof HtmlCommandButton){
						((HtmlCommandButton)child).setDisabled(disable);
					}else{
						disableAllChildButtons(child, disable);
					}
				}
			}
		}catch(Exception e){
			throw new Exception(e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_UI_B_CHECK_LABEL() {
		return COMP_UI_B_CHECK_LABEL;
	}

	public void setCOMP_UI_B_CHECK_LABEL(HtmlOutputLabel comp_ui_b_check_label) {
		COMP_UI_B_CHECK_LABEL = comp_ui_b_check_label;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CHECK() {
		return COMP_CHECK;
	}

	public void setCOMP_CHECK(HtmlSelectBooleanCheckbox comp_check) {
		COMP_CHECK = comp_check;
	}

	public LoginVirtualKeyboardBean getLoginVirtualKeyboardBean() {
		return loginVirtualKeyboardBean;
	}

	public void setLoginVirtualKeyboardBean(LoginVirtualKeyboardBean loginVirtualKeyboardBean) {
		this.loginVirtualKeyboardBean = loginVirtualKeyboardBean;
	}

	public HtmlPanelGrid getCOMP_ALPHABET_GRID() {
		return COMP_ALPHABET_GRID;
	}

	public void setCOMP_ALPHABET_GRID(HtmlPanelGrid comp_alphabet_grid) {
		COMP_ALPHABET_GRID = comp_alphabet_grid;
	}

	public HtmlPanelGrid getCOMP_NUMERIC_GRID() {
		return COMP_NUMERIC_GRID;
	}

	public void setCOMP_NUMERIC_GRID(HtmlPanelGrid comp_numeric_grid) {
		COMP_NUMERIC_GRID = comp_numeric_grid;
	}

	public HtmlPanelGrid getCOMP_SPLKEYS_GRID() {
		return COMP_SPLKEYS_GRID;
	}

	public void setCOMP_SPLKEYS_GRID(HtmlPanelGrid comp_splkeys_grid) {
		COMP_SPLKEYS_GRID = comp_splkeys_grid;
	}

	public HtmlPanelGrid getCOMP_VIRTUAL_GRID() {
		return COMP_VIRTUAL_GRID;
	}

	public void setCOMP_VIRTUAL_GRID(HtmlPanelGrid comp_virtual_grid) {
		COMP_VIRTUAL_GRID = comp_virtual_grid;
	}

	public ArrayList<String> getAlphabetCharsList() {
		return alphabetCharsList;
	}

	public void setAlphabetCharsList(ArrayList<String> alphabetCharsList) {
		this.alphabetCharsList = alphabetCharsList;
	}

	public ArrayList<String> getSplCharsList() {
		return splCharsList;
	}

	public void setSplCharsList(ArrayList<String> splCharsList) {
		this.splCharsList = splCharsList;
	}

	public ArrayList<String> getNumericCharsList() {
		return numericCharsList;
	}

	public void setNumericCharsList(ArrayList<String> numericCharsList) {
		this.numericCharsList = numericCharsList;
	}

	public LangConstants getLangConst() {
		return langConst;
	}

	public void setLangConst(LangConstants langConst) {
		this.langConst = langConst;
	}

	
	private String vcardimage;
	
	
	

	public String getVcardimage() {
		return vcardimage;
	}

	public void setVcardimage(String vcardimage) {
		this.vcardimage = vcardimage;
	}
	
	public void vcard_image()
	{
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		/*ServletContext ctx = request.getServletContext();*/
		String webContentRoot =  servletContext.getRealPath(File.separator);
		System.out.println("webContentRoot--->"+webContentRoot);
		//webContentRoot = webContentRoot.replace("/", "\\");	
		String fileUploadPath = webContentRoot.substring(0,
				StringUtils.lastIndexOf(webContentRoot,File.separator+"standalone"));
		fileUploadPath = fileUploadPath + File.separator+"welcome-content";
		//path=fileUploadPath.replace("/", "//");
		String path=fileUploadPath;
		String uploadPath = new File(path).getParent()+File.separator+"docs\\Premia\\";
		System.out.println(path +"    path");
		
	//	VcardBean vcardBean = (VcardBean) vcardAction.getVcardTable().getRowData();
		LoginManagedBean loginManagedBean = null;
		loginManagedBean = (LoginManagedBean) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("loginManagedBean");
		loginManagedBean.getLoginBean().getUserName();
	     setVcardimage(uploadPath+loginManagedBean.getLoginBean().getUserName()+".jpg");
		
		System.out.println("getVcardimage                    :"+getVcardimage());
	}
	

}
