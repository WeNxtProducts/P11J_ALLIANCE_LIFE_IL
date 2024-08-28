package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION extends CommonAction{

	private String M_DIVN_CODE;
	private String M_CUST_APPL_ALL_BRAN_YN;
	private String M_NAME;
	private String M_BL_NAME;
	private String M_FRZ_FLAG;
	private UIDataTable dataTable;

	private HtmlOutputLabel COMP_FCPCE_CUST_CODE_LABEL;

	private HtmlInputText COMP_FCPCE_CUST_CODE;

	private HtmlOutputLabel COMP_FCPCE_FAC_PERC_LABEL;

	private HtmlInputText COMP_FCPCE_FAC_PERC;

	private HtmlOutputLabel COMP_FCPCE_FC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCE_FC_CLM_EST;

	private HtmlOutputLabel COMP_FCPCE_RETRO_PERC_LABEL;

	private HtmlInputText COMP_FCPCE_RETRO_PERC;

	private HtmlOutputLabel COMP_FCPCE_RETRO_FC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCE_RETRO_FC_CLM_EST;

	private HtmlOutputLabel COMP_FCPCE_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCE_LC_CLM_EST;

	private HtmlOutputLabel COMP_FCPCE_RETRO_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCE_RETRO_LC_CLM_EST;

	private HtmlCommandButton COMP_UI_M_BUT_FAC_HIST;
	
	private HtmlSelectBooleanCheckbox checkBox;
	
	private String filterByFCPCE_CUST_CODE;
	
	private String filterByFCPCE_FAC_PERC;
	
	private String filterByFCPCE_FC_CLM_EST;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private PT_IL_FAC_CLAIM_PART_CUST_EST PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN;

	private ResultSet resultSet;
	private CRUDHandler handler = null;
	private Connection connection = null;

	List<PT_IL_FAC_CLAIM_PART_CUST_EST> BeanList = new ArrayList<PT_IL_FAC_CLAIM_PART_CUST_EST>();
	
	public PILT011_COMPOSITE_ACTION compositeAction;

	public PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION() {
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = new PT_IL_FAC_CLAIM_PART_CUST_EST();
		handler = new CRUDHandler();
		BeanList.add(new PT_IL_FAC_CLAIM_PART_CUST_EST());
	}

	public HtmlOutputLabel getCOMP_FCPCE_CUST_CODE_LABEL() {
		return COMP_FCPCE_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_CUST_CODE() {
		return COMP_FCPCE_CUST_CODE;
	}

	public void setCOMP_FCPCE_CUST_CODE_LABEL(HtmlOutputLabel COMP_FCPCE_CUST_CODE_LABEL) {
		this.COMP_FCPCE_CUST_CODE_LABEL = COMP_FCPCE_CUST_CODE_LABEL;
	}

	public void setCOMP_FCPCE_CUST_CODE(HtmlInputText COMP_FCPCE_CUST_CODE) {
		this.COMP_FCPCE_CUST_CODE = COMP_FCPCE_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_FCPCE_FAC_PERC_LABEL() {
		return COMP_FCPCE_FAC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_FAC_PERC() {
		return COMP_FCPCE_FAC_PERC;
	}

	public void setCOMP_FCPCE_FAC_PERC_LABEL(HtmlOutputLabel COMP_FCPCE_FAC_PERC_LABEL) {
		this.COMP_FCPCE_FAC_PERC_LABEL = COMP_FCPCE_FAC_PERC_LABEL;
	}

	public void setCOMP_FCPCE_FAC_PERC(HtmlInputText COMP_FCPCE_FAC_PERC) {
		this.COMP_FCPCE_FAC_PERC = COMP_FCPCE_FAC_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCE_FC_CLM_EST_LABEL() {
		return COMP_FCPCE_FC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_FC_CLM_EST() {
		return COMP_FCPCE_FC_CLM_EST;
	}

	public void setCOMP_FCPCE_FC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCE_FC_CLM_EST_LABEL) {
		this.COMP_FCPCE_FC_CLM_EST_LABEL = COMP_FCPCE_FC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCE_FC_CLM_EST(HtmlInputText COMP_FCPCE_FC_CLM_EST) {
		this.COMP_FCPCE_FC_CLM_EST = COMP_FCPCE_FC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_FCPCE_RETRO_PERC_LABEL() {
		return COMP_FCPCE_RETRO_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_RETRO_PERC() {
		return COMP_FCPCE_RETRO_PERC;
	}

	public void setCOMP_FCPCE_RETRO_PERC_LABEL(HtmlOutputLabel COMP_FCPCE_RETRO_PERC_LABEL) {
		this.COMP_FCPCE_RETRO_PERC_LABEL = COMP_FCPCE_RETRO_PERC_LABEL;
	}

	public void setCOMP_FCPCE_RETRO_PERC(HtmlInputText COMP_FCPCE_RETRO_PERC) {
		this.COMP_FCPCE_RETRO_PERC = COMP_FCPCE_RETRO_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCE_RETRO_FC_CLM_EST_LABEL() {
		return COMP_FCPCE_RETRO_FC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_RETRO_FC_CLM_EST() {
		return COMP_FCPCE_RETRO_FC_CLM_EST;
	}

	public void setCOMP_FCPCE_RETRO_FC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCE_RETRO_FC_CLM_EST_LABEL) {
		this.COMP_FCPCE_RETRO_FC_CLM_EST_LABEL = COMP_FCPCE_RETRO_FC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCE_RETRO_FC_CLM_EST(HtmlInputText COMP_FCPCE_RETRO_FC_CLM_EST) {
		this.COMP_FCPCE_RETRO_FC_CLM_EST = COMP_FCPCE_RETRO_FC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_FCPCE_LC_CLM_EST_LABEL() {
		return COMP_FCPCE_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_LC_CLM_EST() {
		return COMP_FCPCE_LC_CLM_EST;
	}

	public void setCOMP_FCPCE_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCE_LC_CLM_EST_LABEL) {
		this.COMP_FCPCE_LC_CLM_EST_LABEL = COMP_FCPCE_LC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCE_LC_CLM_EST(HtmlInputText COMP_FCPCE_LC_CLM_EST) {
		this.COMP_FCPCE_LC_CLM_EST = COMP_FCPCE_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_FCPCE_RETRO_LC_CLM_EST_LABEL() {
		return COMP_FCPCE_RETRO_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCE_RETRO_LC_CLM_EST() {
		return COMP_FCPCE_RETRO_LC_CLM_EST;
	}

	public void setCOMP_FCPCE_RETRO_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCE_RETRO_LC_CLM_EST_LABEL) {
		this.COMP_FCPCE_RETRO_LC_CLM_EST_LABEL = COMP_FCPCE_RETRO_LC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCE_RETRO_LC_CLM_EST(HtmlInputText COMP_FCPCE_RETRO_LC_CLM_EST) {
		this.COMP_FCPCE_RETRO_LC_CLM_EST = COMP_FCPCE_RETRO_LC_CLM_EST;
	}

	public PT_IL_FAC_CLAIM_PART_CUST_EST getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN() {
		return PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN;
	}

	public void setPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN(PT_IL_FAC_CLAIM_PART_CUST_EST PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN) {
		this.PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN;
	}

	public String getM_DIVN_CODE() {
		return M_DIVN_CODE;
	}

	public void setM_DIVN_CODE(String m_divn_code) {
		M_DIVN_CODE = m_divn_code;
	}

	public String getM_CUST_APPL_ALL_BRAN_YN() {
		return M_CUST_APPL_ALL_BRAN_YN;
	}

	public void setM_CUST_APPL_ALL_BRAN_YN(String m_cust_appl_all_bran_yn) {
		M_CUST_APPL_ALL_BRAN_YN = m_cust_appl_all_bran_yn;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_name) {
		M_NAME = m_name;
	}

	public String getM_BL_NAME() {
		return M_BL_NAME;
	}

	public void setM_BL_NAME(String m_bl_name) {
		M_BL_NAME = m_bl_name;
	}

	public String getM_FRZ_FLAG() {
		return M_FRZ_FLAG;
	}

	public void setM_FRZ_FLAG(String m_frz_flag) {
		M_FRZ_FLAG = m_frz_flag;
	}
	public void PT_IL_FAC_CLAIM_PART_CUST_EST_PRE_UPDATE() throws Exception{
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_UPD_DT(getSystemDate());
	}
	public void PT_IL_FAC_CLAIM_PART_CUST_EST_PRE_INSERT(){
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCE_CR_DT(getSystemDate());
	}
	public void PT_IL_FAC_CLAIM_PART_CUST_EST_POST_QUERY(){
		String P_CUST_NAME = P_VAL_CUST(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCPCE_CUST_CODE(), PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getM_CUST_NAME_1(), "N", CommonUtils.getControlBean().getM_LANG_CODE());
	}

	public String P_VAL_CUST(String P_CUST_CODE,String P_CUST_NAME,String P_NAME_FLAG,String P_ERR_FLAG){
		connection = getConnection();
		String P_DIVN_CODE = null;
		setM_DIVN_CODE(P_DIVN_CODE);
		String C1 = "SELECT DECODE('"+P_NAME_FLAG+"','N',CUST_NAME,CUST_SHORT_NAME),DECODE('"+P_NAME_FLAG+"','N',CUST_BL_NAME,CUST_BL_SHORT_NAME),CUST_FRZ_FLAG FROM PM_CUSTOMER WHERE CUST_CODE = '"+P_CUST_CODE+"' AND CUST_CODE IN ( SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_CUST_CODE = CUST_CODE AND CDIV_DIVN_CODE = NVL(M_DIVN_CODE, CDIV_DIVN_CODE))";
		String C1A = "SELECT DECODE('"+P_NAME_FLAG+"','N',CUST_NAME,CUST_SHORT_NAME), DECODE('"+P_NAME_FLAG+"','N',CUST_BL_NAME,CUST_BL_SHORT_NAME), CUST_FRZ_FLAG FROM PM_CUSTOMER WHERE CUST_CODE = '"+P_CUST_CODE+"'";
		String C2 = "SELECT CUST_APPL_ALL_BRAN_YN FROM PM_CUSTOMER WHERE CUST_CODE = '"+P_CUST_CODE+"'";

		try {
			resultSet = handler.executeSelectStatement(C2, connection);
			while(resultSet.next()){
				setM_CUST_APPL_ALL_BRAN_YN(resultSet.getString(1)); 
				
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		if(getM_CUST_APPL_ALL_BRAN_YN().equals("N")){
			try {
				resultSet = handler.executeSelectStatement(C1, connection);
				if(resultSet != null){
					while(resultSet.next()){
						setM_NAME(resultSet.getString(1));
						setM_BL_NAME(resultSet.getString(2));
						setM_FRZ_FLAG(resultSet.getString(3));
					}
				}else{
					if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")){
						if(P_ERR_FLAG.equals("E")){
							getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1007").getDetail());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}else if(getM_CUST_APPL_ALL_BRAN_YN().equals("Y")){
			try {
				resultSet = handler.executeSelectStatement(C1A, connection);
				if(resultSet != null){
					while(resultSet.next()){
						setM_NAME(resultSet.getString(1));
						setM_BL_NAME(resultSet.getString(2));
						setM_FRZ_FLAG(resultSet.getString(3));
					}
				}else{
					if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")){
						if(P_ERR_FLAG.equals("E")){
							getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1007").getDetail());
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(getM_FRZ_FLAG().equals("Y")){
			if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")){
				if(P_ERR_FLAG.equals("E")){
					getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1024").getDetail());
				}
			}
		}
		/*if(session.get("GLOBAL.M_FOR_LANG_CODE").toString().substring(4,5).equals("1") || session.get("GLOBAL.M_LANG_CODE").toString().equals("ENG")){
			P_CUST_NAME = getM_NAME();
		}else{
			P_CUST_NAME = getM_BL_NAME();
		}*/
		return P_CUST_NAME;
	}

	public void FCPCE_CUST_CODE_WHEN_VALIDATE_ITEM(ActionEvent ae){
		UIInput uiInput = (UIInput)ae.getComponent().getParent();
		/*		int currRowIndex = getdataTable().getRowIndex();
		System.out.println("Row Index >>>>>> "+currRowIndex);
//		gridValueBean = (PM_AGENT_BONUS_APPL_PROD)dataTableList.get(currRowIndex);
		PT_IL_FAC_CLAIM_PART_CUST_EST bean = (PT_IL_FAC_CLAIM_PART_CUST_EST) getdataTable().getRowData();
		System.out.println(bean.getFCPCE_CUST_CODE());
		 */
	//	String P_CUST_NAME = P_VAL_CUST(uiInput.getSubmittedValue().toString(),PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getM_CUST_NAME_1(),"N",CommonUtils.getControlBean().getM_LANG_CODE());
	}

	/*
  P_VAL_CUST(:PT_IL_FAC_CLAIM_PART_CUST_EST.FCPCE_CUST_CODE,
	   :DUMMY.M_CUST_NAME_1,
           'N',
	   :CTRL.M_LANG_CODE);

	 */  
//	public CTRL getControlBean(){
//		FacesContext faces = FacesContext.getCurrentInstance();
//		session = faces.getExternalContext().getSessionMap();
//		return (CTRL)session.get("ctrlbean");
//	}

	public Date getSystemDate(){
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysDate;
	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public UIDataTable getdataTable() {
		return dataTable;
	}

	public void setdataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List<PT_IL_FAC_CLAIM_PART_CUST_EST> getBeanList() {
		return BeanList;
	}

	public void setBeanList(List<PT_IL_FAC_CLAIM_PART_CUST_EST> beanList) {
		BeanList = beanList;
	}

	public void saveRecord() throws Exception{
		/*		connection = getConnection();
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = BeanList.get(rowIndex);
		handler.executeInsert(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN, connection);
		connection.commit();
		 */	}
	public void addRow(ActionEvent ae){
		BeanList.add(new PT_IL_FAC_CLAIM_PART_CUST_EST());
	}
	public List<PT_IL_FAC_CLAIM_PART_CUST_EST> getPT_IL_FAC_CLAIM_EST_LIST(){
		PT_IL_FAC_CLAIM_EST_ACTION claimESTAction = compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN();
		return claimESTAction.getClaimPartCustList();
	}

	public void checkBoxStatus(ActionEvent actionEvent){
		//session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		List<PT_IL_FAC_CLAIM_PART_CUST_EST>  claimPartCustList = getPT_IL_FAC_CLAIM_EST_LIST();
		int rowIndex = getdataTable().getRowIndex();
		PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = claimPartCustList.get(rowIndex);
		if(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.isCHECK_BOX()){
			CommonUtils.setGlobalVariable("CUSTOMER_CODE", PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCPCE_CUST_CODE());
		}else{
			CommonUtils.setGlobalVariable("CUSTOMER_CODE", "");
		}
	}
	public void deleteRow(ActionEvent ae) throws Exception{
		PT_IL_FAC_CLAIM_PART_CUST_EST valueBean = null;
		int DeletedRecordIndex = 0;
		connection = getConnection();
		if(BeanList != null){
			for(int index =0 ;index<BeanList.size();){
				valueBean = BeanList.get(index);
				if(valueBean.isCHECK_BOX()){
					BeanList.remove(valueBean);
					int n = handler.executeDelete(valueBean, connection);
					connection.commit();
				}else{
					index++;
				}
			}
		}
	}
	
	public void getDetails() {
		//List<PT_IL_FAC_CLAIM_PART_CUST_EST>  claimPartCustList = (ArrayList<PT_IL_FAC_CLAIM_PART_CUST_EST>)CommonUtils.getGlobalVariable("CUST_DTLS_LIST");
		try {
			if (BeanList.size() != 0) {				
				PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = (PT_IL_FAC_CLAIM_PART_CUST_EST) dataTable.getRowData();
			}	
			PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION claimPartCustAction = compositeAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN();
			resetAllComponent();			
			resetSelectedRow();
			//setPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN(PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
			PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
		
	private void resetSelectedRow() {
			List<PT_IL_FAC_CLAIM_PART_CUST_EST>  claimPartCustList = getPT_IL_FAC_CLAIM_EST_LIST();
			Iterator<PT_IL_FAC_CLAIM_PART_CUST_EST> iterator = claimPartCustList.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}
		
		public void resetAllComponent()
		{
			COMP_FCPCE_CUST_CODE.resetValue();
			COMP_FCPCE_FAC_PERC.resetValue();
			COMP_FCPCE_FC_CLM_EST.resetValue();
			COMP_FCPCE_RETRO_PERC.resetValue();
			COMP_FCPCE_RETRO_FC_CLM_EST.resetValue();
			COMP_FCPCE_LC_CLM_EST.resetValue();
			COMP_FCPCE_RETRO_LC_CLM_EST.resetValue();
		}

	public HtmlCommandButton getCOMP_UI_M_BUT_FAC_HIST() {
		return COMP_UI_M_BUT_FAC_HIST;
	}

	public void setCOMP_UI_M_BUT_FAC_HIST(HtmlCommandButton comp_ui_m_but_fac_hist) {
		COMP_UI_M_BUT_FAC_HIST = comp_ui_m_but_fac_hist;
	}

	public String UI_M_BUT_FAC_HIST_BUTTON_PRESSED(){
		if(CommonUtils.getGlobalVariable("CUSTOMER_CODE") == null){
			
			CommonUtils.setGlobalVariable("CUSTOMER_CODE",PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCPCE_CUST_CODE());
			compositeAction.getPH_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().setBlockFlag(true);
			/*List<PT_IL_FAC_CLAIM_PART_CUST_EST>  claimPartCustList = getPT_IL_FAC_CLAIM_EST_LIST();
			if (claimPartCustList != null) {
				if (claimPartCustList.size() > 0) {
					PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN = claimPartCustList.get(0);
					CommonUtils.setGlobalVariable("CUSTOMER_CODE", PT_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCPCE_CUST_CODE());
					//compositeAction.getPH_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().getPH_IL_FAC_CLAIM_PART_CUST_EST_Dtls();
				}
			}*/
		}
		return "claim_part_cust_est";
	}

	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}

	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	/**
	 * @return the dataTable
	 */
	public UIDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the filterByFCPCE_CUST_CODE
	 */
	public String getFilterByFCPCE_CUST_CODE() {
		return filterByFCPCE_CUST_CODE;
	}

	/**
	 * @param filterByFCPCE_CUST_CODE the filterByFCPCE_CUST_CODE to set
	 */
	public void setFilterByFCPCE_CUST_CODE(String filterByFCPCE_CUST_CODE) {
		this.filterByFCPCE_CUST_CODE = filterByFCPCE_CUST_CODE;
	}

	/**
	 * @return the filterByFCPCE_FAC_PERC
	 */
	public String getFilterByFCPCE_FAC_PERC() {
		return filterByFCPCE_FAC_PERC;
	}

	/**
	 * @param filterByFCPCE_FAC_PERC the filterByFCPCE_FAC_PERC to set
	 */
	public void setFilterByFCPCE_FAC_PERC(String filterByFCPCE_FAC_PERC) {
		this.filterByFCPCE_FAC_PERC = filterByFCPCE_FAC_PERC;
	}

	/**
	 * @return the filterByFCPCE_FC_CLM_EST
	 */
	public String getFilterByFCPCE_FC_CLM_EST() {
		return filterByFCPCE_FC_CLM_EST;
	}

	/**
	 * @param filterByFCPCE_FC_CLM_EST the filterByFCPCE_FC_CLM_EST to set
	 */
	public void setFilterByFCPCE_FC_CLM_EST(String filterByFCPCE_FC_CLM_EST) {
		this.filterByFCPCE_FC_CLM_EST = filterByFCPCE_FC_CLM_EST;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}
}
