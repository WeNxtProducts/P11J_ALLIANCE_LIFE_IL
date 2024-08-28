package com.iii.pel.forms.PILM106;





import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectManyListbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
public class PILM106_EMAIL_ACTION extends CommonAction {
	private ResourceBundle Filter = ResourceBundle.getBundle("messageProperties_PILM106");
	private PILM106_EMAIL_BEAN emailBean;
	private PILM106_EMAIL_LIST productlist;
	private SelectItem selected;
	private HtmlInputText COMP_EMAIL_FROM;
	private HtmlInputText COMP_EMAIL_SUBJECT;
	private HtmlInputText COMP_PROD_CODE;

	private HtmlInputTextarea COMP_EMAIL_BODY;
	/*added by krithika for call id FALCONQC-1716214  */
	private HtmlInputTextarea COMP_FRM_HIDE;
	private HtmlInputTextarea COMP_FRM_HIDE_TO;
	
	public HtmlInputTextarea getCOMP_FRM_HIDE() {
		return COMP_FRM_HIDE;
	}
	public void setCOMP_FRM_HIDE(HtmlInputTextarea cOMP_FRM_HIDE) {
		COMP_FRM_HIDE = cOMP_FRM_HIDE;
	}
	public HtmlInputTextarea getCOMP_FRM_HIDE_TO() {
		return COMP_FRM_HIDE_TO;
	}
	public void setCOMP_FRM_HIDE_TO(HtmlInputTextarea cOMP_FRM_HIDE_TO) {
		COMP_FRM_HIDE_TO = cOMP_FRM_HIDE_TO;
	}
//end
	private HtmlOutputLabel COMP_EMAIL_PRODUCT_LABEL;
	private HtmlSelectOneMenu COMP_EMAIL_PRODUCT;
	private HtmlSelectBooleanCheckbox COMP_FRZ_YN;
	private HtmlSelectBooleanCheckbox COMP_ATTACHMENT_YN;
	private HtmlCalendar  COMP_MAIL_EFF_FM__DT;
	private HtmlCalendar  COMP_MAIL_EFF_TO__DT;
	public  List<PILM106_EMAIL_LIST> flist_list = new ArrayList<PILM106_EMAIL_LIST>();
	
	
	public  List<SelectItem> select_Menu_list = new ArrayList<SelectItem>();
	private PILM106_EMAIL_HELPER helperBean;
	private PILM106_EMAIL_DELEGATE delegateBean;
	public PILM106_EMAIL_COMPOSITE_ACTION compositeAction;
	private HtmlCommandButton COMP_ADD_BODY;
	public static StringBuffer sb=new StringBuffer(); 
	private static String Selected = "";
	private UIData dataTable;
	private HtmlOutputText LinkText;
	
	
	/*Added by ganesh on 28-06-2017,ZBILQC-1725181*/
	StringBuilder fetchKeys = null;
	/*End*/
	
	
	public HtmlOutputText getLinkText() {

		return LinkText;
	}
	public void setLinkText(HtmlOutputText linkText) {
		LinkText = linkText;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	public HtmlSelectBooleanCheckbox getCOMP_FRZ_YN() {
		return COMP_FRZ_YN;
	}
	public void setCOMP_FRZ_YN(HtmlSelectBooleanCheckbox cOMP_FRZ_YN) {
		COMP_FRZ_YN = cOMP_FRZ_YN;
	}

	public HtmlCommandButton getCOMP_ADD_BODY() {
		return COMP_ADD_BODY;
	}

	public void setCOMP_ADD_BODY(HtmlCommandButton cOMP_ADD_BODY) {
		COMP_ADD_BODY = cOMP_ADD_BODY;
	}

	public boolean isButtonflag() {
		return buttonflag;
	}

	public void setButtonflag(boolean buttonflag) {
		this.buttonflag = buttonflag;
	}
	private boolean buttonflag;

	public HtmlInputTextarea getCOMP_EMAIL_BODY() {
		return COMP_EMAIL_BODY;
	}

	public void setCOMP_EMAIL_BODY(HtmlInputTextarea cOMP_EMAIL_BODY) {
		COMP_EMAIL_BODY = cOMP_EMAIL_BODY;
	}


	public PILM106_EMAIL_HELPER getHelperBean() {
		return helperBean;
	}

	public void setHelperBean(PILM106_EMAIL_HELPER helperBean) {
		this.helperBean = helperBean;
	}

	public PILM106_EMAIL_DELEGATE getDelegateBean() {
		return delegateBean;
	}

	public void setDelegateBean(PILM106_EMAIL_DELEGATE delegateBean) {
		this.delegateBean = delegateBean;
	}

	public PILM106_EMAIL_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM106_EMAIL_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlInputText getCOMP_PROD_CODE() {
		return COMP_PROD_CODE;
	}

	public void setCOMP_PROD_CODE(HtmlInputText cOMP_PROD_CODE) {
		COMP_PROD_CODE = cOMP_PROD_CODE;
	}


	public SelectItem getSelected() {
		return selected;
	}

	public void setSelected(SelectItem selected) {
		this.selected = selected;
	}

	public void setSelect_Menu_list(List<SelectItem> select_Menu_list) {
		this.select_Menu_list = select_Menu_list;
	}

	public HtmlOutputLabel getCOMP_EMAIL_PRODUCT_LABEL() {
		return COMP_EMAIL_PRODUCT_LABEL;
	}

	public void setCOMP_EMAIL_PRODUCT_LABEL(HtmlOutputLabel cOMP_EMAIL_PRODUCT_LABEL) {
		COMP_EMAIL_PRODUCT_LABEL = cOMP_EMAIL_PRODUCT_LABEL;
	}


	public HtmlSelectBooleanCheckbox getCOMP_ATTACHMENT_YN() {
		return COMP_ATTACHMENT_YN;
	}

	public void setCOMP_ATTACHMENT_YN(HtmlSelectBooleanCheckbox cOMP_ATTACHMENT_YN) {
		COMP_ATTACHMENT_YN = cOMP_ATTACHMENT_YN;
	}
	public List<SelectItem> getSelect_Menu_list() {

		try {
			select_Menu_list = delegateBean.MAIL_TYPE_LIST();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("MAIL_TYPE_LIST",e.getMessage());
		}
		return select_Menu_list;
	}
	public List<PILM106_EMAIL_LIST> getFlist_list() {

		return flist_list;
	}
	public void setFlist_list(List<PILM106_EMAIL_LIST> flist_list) {
		this.flist_list = flist_list;
	}
	public HtmlCalendar getCOMP_MAIL_EFF_FM__DT() {
		return COMP_MAIL_EFF_FM__DT;
	}

	public void setCOMP_MAIL_EFF_FM__DT(HtmlCalendar cOMP_MAIL_EFF_FM__DT) {
		COMP_MAIL_EFF_FM__DT = cOMP_MAIL_EFF_FM__DT;
	}
	public HtmlCalendar getCOMP_MAIL_EFF_TO__DT() {
		return COMP_MAIL_EFF_TO__DT;
	}

	public void setCOMP_MAIL_EFF_TO__DT(HtmlCalendar cOMP_MAIL_EFF_TO__DT) {
		COMP_MAIL_EFF_TO__DT = cOMP_MAIL_EFF_TO__DT;
	}
	public HtmlInputText getCOMP_EMAIL_FROM() {
		return COMP_EMAIL_FROM;
	}
	public void setCOMP_EMAIL_FROM(HtmlInputText cOMP_EMAIL_FROM) {
		COMP_EMAIL_FROM = cOMP_EMAIL_FROM;
	}
	public HtmlInputText getCOMP_EMAIL_SUBJECT() {
		return COMP_EMAIL_SUBJECT;
	}
	public void setCOMP_EMAIL_SUBJECT(HtmlInputText cOMP_EMAIL_SUBJECT) {
		COMP_EMAIL_SUBJECT = cOMP_EMAIL_SUBJECT;
	}

	public HtmlSelectOneMenu getCOMP_EMAIL_PRODUCT() {
		return COMP_EMAIL_PRODUCT;
	}
	public void setCOMP_EMAIL_PRODUCT(HtmlSelectOneMenu cOMP_EMAIL_PRODUCT) {
		COMP_EMAIL_PRODUCT = cOMP_EMAIL_PRODUCT;
	}
	public PILM106_EMAIL_BEAN getEmailBean() {
		return emailBean;
	}
	public void setEmailBean(PILM106_EMAIL_BEAN emailBean) {
		this.emailBean = emailBean;
	}
	public PILM106_EMAIL_LIST getProductlist() {
		return productlist;
	}
	/*Constructor*/
	public PILM106_EMAIL_ACTION()
	{

		productlist= new PILM106_EMAIL_LIST();
		/*added by krithika for call id FALCONQC-1716214  */
		try {
			listSelectkey=preparepolstatus();
			
			/*Added by Janani on 28.12.2017 for Mail CC*/
			listUserType = getUserType();
			/*End*/
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//end
		emailBean = new PILM106_EMAIL_BEAN();
		helperBean = new PILM106_EMAIL_HELPER();
		delegateBean = new PILM106_EMAIL_DELEGATE();
		getSelect_Menu_list();
		COMP_PROD_CODE = new HtmlInputText();
		

	}

	public void setProductlist(PILM106_EMAIL_LIST productlist) {
		this.productlist = productlist;
	}
	public void fromAction(ActionEvent event) {

		UIInput input = (UIInput) event.getComponent().getParent();
		String FROMID = ((String)input.getSubmittedValue());
		emailBean.setPMT_MAIL_FM((String) input.getSubmittedValue());
		System.out.println("I m fom bean"+emailBean.getPMT_MAIL_FM());

	}
	public void addAction(){
		System.out.println("addAction()");
		resetSelectedRow();
		getProductlist().setRowSelected(false);
		emailBean.setPMT_MAIL_TEXT(sb.toString());
		System.out.println(emailBean.getPMT_MAIL_TEXT());
	}

	public void productAction(ActionEvent event)  {
		UIInput input = (UIInput)event.getComponent().getParent();

		emailBean.setPMT_MAIL_TYPE((String)input.getSubmittedValue());

		if(emailBean.getPMT_MAIL_TYPE().equals("FGP")){
			emailBean.setPMT_PROD_CODE("0");
			COMP_PROD_CODE.setDisabled(true);
		}else{
			emailBean.setPMT_PROD_CODE(null);
			COMP_PROD_CODE.setDisabled(false);
		}
		COMP_PROD_CODE.resetValue();
		System.out.println("from bean"+emailBean.getPMT_MAIL_TYPE());
		try {
			getHelperBean().executeSelectStatement(compositeAction,(String) input.getSubmittedValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Flist_list             "+compositeAction.getEMAIL_ACTION_BEAN().getFlist_list());



	}
	public void subjectAction(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		System.out.println( (String)input.getSubmittedValue());
		emailBean.setPMT_MAIL_SUB((String) input.getSubmittedValue());
		System.out.println("i m from been"+emailBean.getPMT_MAIL_SUB());

	}

	public void setenable() {
		resetSelectedRow();
		System.out.println("entered");

		productlist = (PILM106_EMAIL_LIST) dataTable.getRowData();
		Selected=Selected+productlist.getEMAIL_KEY()+",";
		System.out.println("cfvuibiugnihyh"+Selected);
		//sb.append("~");
		sb.append("~"+productlist.getEMAIL_KEY());
		//sb.append("~");

		System.out.println(sb.toString());
		emailBean.setSelected(Selected);
		//	productlist.setRowSelected(true);

		getProductlist().setRowSelected(true);

		//compositeAction.getEMAIL_ACTION_BEAN().setProductlist(productlist);


	}
	

	private void resetSelectedRow() {
		System.out.println("Row is reselcted");
		Iterator<PILM106_EMAIL_LIST> PILM106_EMAIL_LIST_ITR = flist_list.iterator();
		while (PILM106_EMAIL_LIST_ITR.hasNext()) {
			PILM106_EMAIL_LIST_ITR.next().setRowSelected(false);
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {

		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void  addcontent(ActionEvent actionEvent){
		System.out.println("i am here");
		sb.delete(0, sb.length());
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		System.out.println((String)input.getSubmittedValue());
		sb.append((String)input.getSubmittedValue());
		emailBean.setPMT_MAIL_TEXT(sb.toString());
		emailBean.setFRM_HIDE(emailBean.getPMT_MAIL_TEXT());
		System.out.println("value of setFRM_HIDE"+emailBean.getFRM_HIDE());
	}
	public void onload(PhaseEvent event){
		try {
			if(isBlockFlag())
			{
				System.out.println("Welcome to body onload");
				
				intiantiateAllcomponent();
				System.out.println("inside if flag");

				helperBean.executeQuery(compositeAction);

				try {
					getHelperBean().executeSelectStatement(compositeAction,compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_MAIL_TYPE());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Flist_list             "+compositeAction.getEMAIL_ACTION_BEAN().getFlist_list());


				if(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().isFRZ_FLAG())
					COMP_FRZ_YN.setSelected(true);
				else
					COMP_FRZ_YN.setSelected(false);
				if(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().isATTACHMENT_FLAG())
					COMP_ATTACHMENT_YN.setSelected(true);
				else
					COMP_ATTACHMENT_YN.setSelected(false);
				if(emailBean.getPMT_MAIL_TYPE()!=null){
					if(emailBean.getPMT_MAIL_TYPE().equalsIgnoreCase("FGP")){					
						compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(true);
					}else{					
						compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(false);
					}
				}else{
					compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(false);
				}
				
				
				/*Modified by ganesh on 30-04-2018 for sms related issues*/
				enableDisableForSMS(emailBean.getPMT_TYPE());
				/*if(emailBean.getPMT_TYPE() != null && emailBean.getPMT_TYPE().equals("S")){
					
					getMAIL_SMS_TO_LABEL().setValue("SMS To");
					getCOMP_MAIL_CC_LABEL().setRendered(false);
					getCOMP_MAIL_CC().setRendered(false);
					COMP_MAIL_CC.setDisabled(true);
					
				}else{

					getMAIL_SMS_TO_LABEL().setValue("Mail To");
					getCOMP_MAIL_CC_LABEL().setRendered(true);
					getCOMP_MAIL_CC().setRendered(true);
					
					COMP_MAIL_CC.setDisabled(false);
					
				}*/
				

				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		//	COMP_PROD_CODE.setDisabled(true);
	}


	public void intiantiateAllcomponent(){  
		dataTable = new UIData();
		LinkText = new HtmlOutputText();
		COMP_EMAIL_FROM = new HtmlInputText();
		COMP_EMAIL_SUBJECT = new HtmlInputText();
		COMP_EMAIL_BODY = new HtmlInputTextarea();
		COMP_EMAIL_PRODUCT = new HtmlSelectOneMenu();
		COMP_MAIL_EFF_FM__DT = new HtmlCalendar();
		COMP_MAIL_EFF_TO__DT = new HtmlCalendar();
		COMP_ATTACHMENT_YN = new HtmlSelectBooleanCheckbox();
		COMP_FRZ_YN	= new HtmlSelectBooleanCheckbox();

		/*Added by janani on 23.02.2018 for SMS as discussed with Girirsh*/
		
		COMP_NOTF_TYPE = new HtmlSelectOneMenu();
		COMP_MAIL_CC = new HtmlSelectManyListbox();
		COMP_CC_GROUP = new HtmlPanelGroup();
		/*End*/
	}


	public void validatorFromID(FacesContext context,UIComponent component, Object value) {
		try {
			if(value!=null){
				emailBean.setPMT_MAIL_FM((String)value);;
				helperBean.FromIDValidator(emailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {
				ErrorHelpUtil
						.getWarningForProcedure(CommonUtils.getConnection(),
								"PMT_MAIL_FM", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void validatorEffectivDateFrom(FacesContext context,UIComponent component, Object value) {
		try {
			if(value!=null){
				emailBean.setPMT_EFF_FM_DT((Date)value);
				helperBean.effectivFromDateValidator(emailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorEffectivDateTo(FacesContext context,UIComponent component, Object value) {
		try {
			if(value!=null){
				emailBean.setPMT_EFF_TO_DT((Date)value);
				helperBean.effectiveToDateValidator(emailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}








	/*Save the  Record into database*/
	public String saveAction() {
		String message = null;
		CRUDHandler handler = new CRUDHandler();
		String filteredkey=Filter.getString("FilterKey");
		System.out.println("demooo 123");
		CommonUtils.clearMaps(this);
		try {
			System.out.println("ROW --------====ID"+this.emailBean.getROWID());
			
			/*Added by Ram on 18/08/2016 for SSP call id FALCONQC-1714587*/
			System.out.println("MailTYpe        "+compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_MAIL_TYPE());
			System.out.println("ProductCode        "+compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_PROD_CODE());
			
			String dateQuery = null;
			ResultSet rs = null;
			if (this.emailBean.getROWID() == null && this.isINSERT_ALLOWED() == true) { 
				dateQuery = "SELECT PMT_EFF_FM_DT,PMT_EFF_TO_DT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_PROD_CODE = ? AND PMT_MAIL_TYPE = ?";
				rs = handler.executeSelectStatement(dateQuery, CommonUtils.getConnection(),new Object[]{compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_PROD_CODE(),
					compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_MAIL_TYPE()});
			}
			else
			{
				dateQuery = "SELECT PMT_EFF_FM_DT,PMT_EFF_TO_DT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_PROD_CODE = ? AND PMT_MAIL_TYPE = ? AND ROWID != ?";
				rs = handler.executeSelectStatement(dateQuery, CommonUtils.getConnection(),new Object[]{compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_PROD_CODE(),
					compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_MAIL_TYPE(),this.emailBean.getROWID()});
			}
			
			
			Date fromDate = null,toDate = null;
			while(rs.next())
			{
				System.out.println(rs.getDate(1)+"         "+rs.getDate(2));
				fromDate = rs.getDate(1);
				toDate = rs.getDate(2);
				
				/*Commented temporary due to demo by ganesh on 28-04-2018*/ 
				//dateChecking(fromDate,toDate,"F");
				//dateChecking(fromDate,toDate,"D");
			}
			 
			
			/*End*/
			
			
			/*Added by ganesh on 28-06-2017,*/
					
			this.emailBean.setPMT_KEY_MAIL_TO(extractKeyFromList(emailBean.getUI_KEY_MAIL_TO()));
			this.emailBean.setPMT_KEY_MAIL_CC(extractKeyFromList(emailBean.getUI_KEY_MAIL_CC()));
			
			
			
			StringBuilder fetchKeyMailTo = new StringBuilder();
			for(int i=0;i<emailBean.getUI_KEY_MAIL_TO().size(); i++){
				fetchKeyMailTo.append(emailBean.getUI_KEY_MAIL_TO().get(i));
				if(i!=emailBean.getUI_KEY_MAIL_TO().size()-1){
					fetchKeyMailTo.append(",");
				}
			}
			this.emailBean.setPMT_KEY_MAIL_TO(fetchKeyMailTo.toString());
			System.out.println("Mail To--->"+emailBean.getPMT_KEY_MAIL_TO());
			/*end*/
			
			
			if (this.emailBean.getROWID() == null && this.isINSERT_ALLOWED() == true) { 
				System.out.println("save if");
				//System.out.println(getEmailBean().getCOMP_CODE());

				//compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getROWID();
				
				
				System.out.println("Welcome to Save Record in create new Concept");
				
				
				System.out.println("row id"+compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getROWID());
				System.out.println(getEmailBean().isFRZ_FLAG());
				if(getEmailBean().isFRZ_FLAG())
				{
					getEmailBean().setPMT_FRZ_FLAG("Y");
				}
				else
				{
					getEmailBean().setPMT_FRZ_FLAG("N");
				}
				if(getEmailBean().isATTACHMENT_FLAG())
				{
					getEmailBean().setPMT_ATTACH_YN("Y");
				}
				else
				{
					getEmailBean().setPMT_ATTACH_YN("N");
				}
				System.out.println("123456789"+getEmailBean().getPMT_MAIL_TEXT());	
				
				/*Commented by Ram on 18/08/2016 for SSP call id FALCONQC-1714587*/
				/*List<String> list = Arrays.asList(filteredkey.split(","));
				System.out.println(list);
				if(list.contains(getEmailBean().getPMT_MAIL_TYPE())){
					System.out.println("Insert part - Only one Entry in the whole table level");					
					ResultSet rs1=handler.executeSelectStatement(PILM106_A_QUERYCONSTANTS.InsertCond, CommonUtils.getConnection(), new Object[]{getEmailBean().getPMT_MAIL_TYPE()});
					if(rs1.next()){
						throw new Exception("Duplicate entries not allowed!!");
					}
				}else {
					System.out.println("Insert Part - Only one Entry in the table level based on the Product code and Mail type");					
					ResultSet rs1=handler.executeSelectStatement(PILM106_A_QUERYCONSTANTS.CheckTypeDuplicationIns, CommonUtils.getConnection(), new Object[]{getEmailBean().getPMT_MAIL_TYPE(), getEmailBean().getPMT_PROD_CODE()});
					if(rs1.next()){
						throw new Exception("Duplicate entries not allowed for the existing Mail type and Product code!!");
					}
				}*/
				/*End*/
				handler.executeInsert(getEmailBean(), CommonUtils.getConnection());
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");	
				
				CommonUtils.doComitt();
			 
			
			
			} else {
				System.out.println("save else");

				if(getEmailBean().isFRZ_FLAG())
				{
					getEmailBean().setPMT_FRZ_FLAG("Y");
				}
				else
				{
					getEmailBean().setPMT_FRZ_FLAG("N");
				}
				if(getEmailBean().isATTACHMENT_FLAG())
				{
					getEmailBean().setPMT_ATTACH_YN("Y");
				}
				else
				{
					getEmailBean().setPMT_ATTACH_YN("N");
				}
				
				/*Commented by Ram on 18/08/2016 for SSP call id FALCONQC-1714587*/
				/*List<String> list = Arrays.asList(filteredkey.split(","));
				System.out.println(list);
				if(list.contains(getEmailBean().getPMT_MAIL_TYPE())){
					System.out.println("Update part - Only one Entry in the whole table level");					
					ResultSet rs1=handler.executeSelectStatement(PILM106_A_QUERYCONSTANTS.UpdateCond, CommonUtils.getConnection(), new Object[]{getEmailBean().getPMT_MAIL_TYPE(),getEmailBean().getROWID()});
					if(!rs1.next()){
						ResultSet rs2=handler.executeSelectStatement(PILM106_A_QUERYCONSTANTS.InsertCond, CommonUtils.getConnection(), new Object[]{getEmailBean().getPMT_MAIL_TYPE()});
						if(rs2.next()){
							throw new Exception("Duplicates not allowed!!");
						}							
					}
				}else {
					System.out.println("Update Part - Only one Entry in the table level based on the Product code and Mail type");					
					ResultSet rs1=handler.executeSelectStatement(PILM106_A_QUERYCONSTANTS.CheckTypeDuplicationUpd, CommonUtils.getConnection(), new Object[]{getEmailBean().getPMT_MAIL_TYPE(), getEmailBean().getPMT_PROD_CODE(), getEmailBean().getROWID()});
					if(rs1.next()){
						throw new Exception("Duplicate entries not allowed for the existing Mail type and Product code!!");
					}
				}*/	
				/*End*/
				handler.executeUpdate(getEmailBean(), CommonUtils.getConnection());
				message = Messages.getString("messageProperties","errorPanel$message$save");
				/*added by krithika for call id FALCONQC-1716214  */
				emailBean.setFRM_HIDE("");
				emailBean.setFRM_HIDE_TO("");
				COMP_FRM_HIDE.resetValue();
				COMP_FRM_HIDE_TO.resetValue();
				//end
				CommonUtils.doComitt();
				
			}

			message = Messages.getString("messageProperties",
					"errorPanel$message$save");	
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						    e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
			
		}

		return "";
	}


	/*Added by Ram on 18/08/2016 for SSP call id FALCONQC-1714587*/
public void dateChecking(Date fromDate,Date toDate,String flag) throws Exception
{
	 
	 
	
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    System.out.println("PMT_EFF_FM_DT      "+CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_FM_DT()));
    System.out.println("PMT_EFF_TO_DT      "+CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_TO_DT()));
	
	List<Date> dates = new ArrayList<Date>();

	
	String str_date = null;
	String end_date = null;
	String fromDateStr = null;
	String toDateStr = null;
	
	if(flag.equals("F"))
	{
		 str_date = CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_FM_DT());
		 end_date = CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_TO_DT());
		 fromDateStr = dateFormat.format(fromDate);
		 toDateStr = dateFormat.format(toDate);	
	}
	else if(flag.equals("D"))
	{
		 str_date = dateFormat.format(fromDate);
		 end_date = dateFormat.format(toDate);
		 fromDateStr = CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_FM_DT());
		 toDateStr = CommonUtils.dateToStringFormat(compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getPMT_EFF_TO_DT());
	}
	
	
	System.out.println("str_date        "+str_date+"   end_date    "+end_date);
	System.out.println("fromDateStr        "+fromDateStr+"   toDateStr    "+toDateStr);
	
	DateFormat formatter ; 

	formatter = new SimpleDateFormat("dd/MM/yyyy");
	Date  startDate = (Date)formatter.parse(str_date); 
	Date  endDate = (Date)formatter.parse(end_date);
	long interval = 24*1000 * 60 * 60; // 1 hour in millis
	long endTime =endDate.getTime() ; // create your endtime here, possibly using Calendar or Date
	long curTime = startDate.getTime();
	while (curTime <= endTime) {
	    dates.add(new Date(curTime));
	    curTime += interval;
	}
	for(int i=0;i<dates.size();i++){
	    Date lDate =(Date)dates.get(i);
	    String ds = formatter.format(lDate);    
	    if(ds.trim().equals(fromDateStr.trim()) || ds.trim().equals(toDateStr.trim()))
	    {
	    	System.out.println(" if Date is ..." + ds);
	    	throw new Exception("Setup combination is already Available.");
	    }
	  
	}
}

/*End*/
	/*public void saveRecord() {
	try {
	    if (getPT_IL_POLICY_1_BEAN().getROWID() == null && isINSERT_ALLOWED()) {
		new CRUDHandler().executeInsert(getPT_IL_POLICY_1_BEAN(),
			CommonUtils.getConnection());
	    } else   if (getPT_IL_POLICY_1_BEAN().getROWID() != null && isUPDATE_ALLOWED()) {
		new CRUDHandler().executeUpdate(getPT_IL_POLICY_1_BEAN(),
			CommonUtils.getConnection());
	    }
	    CommonUtils.getConnection().commit();
	} catch (Exception e) {
	    getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
		    e.getMessage());
	    getErrorMap().put("SAVE", e.getMessage());
	}
   }
	 */
	/*Delete the  Record into database*/

	public String delAction() {
		String message = null;
		CRUDHandler handler = new CRUDHandler();
		System.out.println("delete 123");
		try {
			System.out.println("inside try");
			delegateBean.preDelete(compositeAction, emailBean);
			message = Messages.getString("messageProperties",
					"errorPanel$message$delete");	
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}


	//Sankar


	//lov

	/*
	 * Commented by Janani on 20.06.2017 for ZBILQC-1721257
	 * 
	 * public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(
			Object currValue) {
		System.out.println("Welcome to lovPOL_PROD_CODE method");
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
					null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/


	

	public void validatorProductcode(FacesContext context,UIComponent component, Object value) {
		try {
			if(value!=null){
				emailBean.setPMT_PROD_CODE((String)value);;
				//helperBean.FromIDValidator(emailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {
				ErrorHelpUtil
						.getWarningForProcedure(CommonUtils.getConnection(),
								"PMT_PROD_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void validatorSubject(FacesContext context,UIComponent component, Object value) {
		try {
			if(value!=null){
				emailBean.setPMT_MAIL_SUB((String)value);
				//helperBean.FromIDValidator(emailBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally {
			try {
				ErrorHelpUtil
						.getWarningForProcedure(CommonUtils.getConnection(),
								"PMT_MAIL_SUB", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	/*added by krithika for call id FALCONQC-1716214  */
	ArrayList<SelectItem> listSelectkey = new ArrayList<SelectItem>();
	

	public ArrayList<SelectItem> getListSelectkey() {
		return listSelectkey;
	}
	public void setListSelectkey(ArrayList<SelectItem> listSelectkey) {
		this.listSelectkey = listSelectkey;
	}
	public ArrayList<SelectItem> preparepolstatus() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<SelectItem> userList = new ArrayList<SelectItem>();
		SelectItem selectItem = null;
		ResultSet resultSet = null;
		String query = "SELECT PEF_COL_NAME, PEF_COL_DESC FROM PW_LIFE_EMAIL_FLDS";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString("PEF_COL_NAME"));
				selectItem.setLabel(resultSet.getString("PEF_COL_DESC"));
				userList.add(selectItem);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return userList;
	}





	//end



/*Added by Janani on 20.06.2017 for ZBILQC-1721257*/	
	
	
	private HtmlInputText COMP_PROD_CODE_DESC;
	
	public HtmlInputText getCOMP_PROD_CODE_DESC() {
		return COMP_PROD_CODE_DESC;
	}
	public void setCOMP_PROD_CODE_DESC(HtmlInputText cOMP_PROD_CODE_DESC) {
		COMP_PROD_CODE_DESC = cOMP_PROD_CODE_DESC;
	}
	
	
	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
	
	public ArrayList<LovBean> lovPOL_PROD_CODE(Object object) {
		
		/*String query = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC  FROM    PM_CUST_CLASS WHERE  CCLAS_FRZ_FLAG = 'N' AND CCLAS_TYPE IN ('002','009') AND ( UPPER(CCLAS_CODE) LIKE UPPER(?)  " +
									"OR  UPPER(CCLAS_CLASS_DESC) LIKE UPPER(?)   ) AND ROWNUM < ? ORDER BY 1";*/

		System.out.println("Enters into lovPOL_PROD_CODE");

		String query = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE "
				+ "(UPPER(PROD_CODE) LIKE UPPER(?) OR  UPPER(PROD_DESC) LIKE UPPER(?)   ) AND ROWNUM < ? ORDER BY 1 ";
		
		
		Object[] values = null;
		String currentValue = (String) object;
		
		
		System.out.println("currentValue               "+currentValue);
		

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	
	/*End*/


	/*Added by ganesh on 28-06-2017,ZBILQC-1725181 */
	public String extractKeyFromList(List<String> lstOfKeys){
		
		fetchKeys = new StringBuilder();
		if(lstOfKeys != null)
		{
		for(int i=0;i<lstOfKeys.size(); i++){
			fetchKeys.append(lstOfKeys.get(i));
			if(i!=lstOfKeys.size()-1){
				fetchKeys.append(",");
			}
		}
		}
		System.out.println("Exctracted Keys--->"+fetchKeys);
		
		return fetchKeys.toString();
		
	}
	
	/*end*/

	
	/*Added by Janani on 28.12.2017 for Mail CC*/
	
	ArrayList<SelectItem> listUserType = new ArrayList<SelectItem>();

	public ArrayList<SelectItem> getListUserType() {
		return listUserType;
	}
	public void setListUserType(ArrayList<SelectItem> listUserType) {
		this.listUserType = listUserType;
	}
	

	public ArrayList<SelectItem> getUserType() throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<SelectItem> userList = new ArrayList<SelectItem>();
		SelectItem selectItem = null;
		ResultSet resultSet = null;
		//String query = "SELECT USER_ID,USER_DESC FROM PW_MENU_USER";
		
		String query = " SELECT USER_ID,USER_DESC FROM MENU_USER";
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString("USER_ID"));
				selectItem.setLabel(resultSet.getString("USER_DESC"));
				userList.add(selectItem);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}  finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return userList;
	}

	
	/*End*/
	
	
	/*Added by janani on 23.02.2018 for SMS as discussed with Girirsh*/
	private HtmlSelectOneMenu COMP_NOTF_TYPE;

	private HtmlOutputLabel COMP_MAIL_CC_LABEL;
	
	private HtmlSelectManyListbox COMP_MAIL_CC;
	
	private HtmlOutputLabel MAIL_SMS_TO_LABEL;
	
	private HtmlPanelGroup COMP_CC_GROUP;
	
	
	
	public HtmlPanelGroup getCOMP_CC_GROUP() {
		return COMP_CC_GROUP;
	}
	public void setCOMP_CC_GROUP(HtmlPanelGroup cOMP_CC_GROUP) {
		COMP_CC_GROUP = cOMP_CC_GROUP;
	}
	public HtmlOutputLabel getMAIL_SMS_TO_LABEL() {
		return MAIL_SMS_TO_LABEL;
	}
	public void setMAIL_SMS_TO_LABEL(HtmlOutputLabel mAIL_SMS_TO_LABEL) {
		MAIL_SMS_TO_LABEL = mAIL_SMS_TO_LABEL;
	}
	public HtmlOutputLabel getCOMP_MAIL_CC_LABEL() {
		return COMP_MAIL_CC_LABEL;
	}
	public void setCOMP_MAIL_CC_LABEL(HtmlOutputLabel cOMP_MAIL_CC_LABEL) {
		COMP_MAIL_CC_LABEL = cOMP_MAIL_CC_LABEL;
	}
	public HtmlSelectManyListbox getCOMP_MAIL_CC() {
		return COMP_MAIL_CC;
	}
	public void setCOMP_MAIL_CC(HtmlSelectManyListbox cOMP_MAIL_CC) {
		COMP_MAIL_CC = cOMP_MAIL_CC;
	}
	public HtmlSelectOneMenu getCOMP_NOTF_TYPE() {
		return COMP_NOTF_TYPE;
	}
	public void setCOMP_NOTF_TYPE(HtmlSelectOneMenu cOMP_NOTF_TYPE) {
		COMP_NOTF_TYPE = cOMP_NOTF_TYPE;
	}
	
	public  List<SelectItem> notf_type_list = new ArrayList<SelectItem>();

	
	public List<SelectItem> getNotf_type_list() {

		try {
			notf_type_list = delegateBean.NOTF_TYPE_LIST();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("NOTF_TYPE_LIST",e.getMessage());
		}
		return notf_type_list;
	}
	
	
	public void setNotf_type_list(List<SelectItem> notf_type_list) {
		this.notf_type_list = notf_type_list;
	}
	
	
	public void notfTypeListener(ActionEvent event)  {
		UIInput input = (UIInput)event.getComponent().getParent();

		try {
		emailBean.setPMT_TYPE((String)input.getSubmittedValue());

		enableDisableForSMS(emailBean.getPMT_TYPE());
		/*if(emailBean.getPMT_TYPE() != null && emailBean.getPMT_TYPE().equals("S")){
			getMAIL_SMS_TO_LABEL().setValue("SMS To");
			//COMP_MAIL_CC_LABEL.setRendered(false);
			//COMP_MAIL_CC.setRendered(false);
			COMP_MAIL_CC.setDisabled(true);
			
		}else{

			getMAIL_SMS_TO_LABEL().setValue("Mail To");
			//COMP_MAIL_CC_LABEL.setRendered(true);
			//COMP_MAIL_CC.setRendered(true);
			COMP_MAIL_CC.setDisabled(false);
		}
		
		COMP_MAIL_CC.resetValue();*/
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public void setPROD_CODE_DESC_VALUE() {
		String PMT_PROD_CODE = (String) this.getCOMP_PROD_CODE()
				.getSubmittedValue();
		this.emailBean.setPMT_PROD_CODE(PMT_PROD_CODE);
		if (lovList != null) {
			Iterator<LovBean> claimIterator = lovList.iterator();
			while (claimIterator.hasNext()) {
				LovBean lovBean = claimIterator.next();
				if (PMT_PROD_CODE != null
						&& PMT_PROD_CODE.equals(lovBean.getCode())) {
					this.getCOMP_PROD_CODE_DESC().setSubmittedValue(
							lovBean.getName());
					this.emailBean.setPROD_CODE_DESC(
							lovBean.getName());
					return;
				}
			}
		}
	}
	
	/*End*/
	
	/*Modified by ganesh on 30-04-2018 for sms related issues*/
	public void enableDisableForSMS(String notificationType){
		
		if(notificationType != null && notificationType.equals("S")){
			getMAIL_SMS_TO_LABEL().setValue("SMS To");			
			COMP_MAIL_CC.setDisabled(true);
			COMP_EMAIL_SUBJECT.setDisabled(true);
			COMP_EMAIL_SUBJECT.setRequired(false);
		}else{

			getMAIL_SMS_TO_LABEL().setValue("Mail To");			
			COMP_MAIL_CC.setDisabled(false);
			COMP_EMAIL_SUBJECT.setDisabled(false);
			COMP_EMAIL_SUBJECT.setRequired(true);
		}
		
		COMP_MAIL_CC.resetValue();
		
	}	
	
	
	
	
}
