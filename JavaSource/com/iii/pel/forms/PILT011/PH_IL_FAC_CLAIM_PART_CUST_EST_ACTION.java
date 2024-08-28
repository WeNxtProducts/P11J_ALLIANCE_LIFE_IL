package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PH_IL_FAC_CLAIM_PART_CUST_EST_ACTION extends CommonAction{

	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private Connection connection = null;
	CRUDHandler handler = null;
	private ResultSet resultSet;

	List<PH_IL_FAC_CLAIM_PART_CUST_EST> claimPartCustEST = new ArrayList<PH_IL_FAC_CLAIM_PART_CUST_EST>();
	UIDataTable uiDataTable;

	private HtmlOutputLabel COMP_FCPCEH_CUST_CODE_LABEL;

	private HtmlInputText COMP_FCPCEH_CUST_CODE;

	private HtmlOutputLabel COMP_FCPCEH_O_FAC_PERC_LABEL;

	private HtmlInputText COMP_FCPCEH_O_FAC_PERC;

	private HtmlOutputLabel COMP_FCPCEH_O_FC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCEH_O_FC_CLM_EST;

	private HtmlOutputLabel COMP_FCPCEH_O_RETRO_PERC_LABEL;

	private HtmlInputText COMP_FCPCEH_O_RETRO_PERC;

	private HtmlOutputLabel COMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCEH_O_RETRO_FC_CLM_EST;

	private HtmlOutputLabel COMP_FCPCEH_O_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCEH_O_LC_CLM_EST;

	private HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CUST_NAME;

	private HtmlOutputLabel COMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_FCPCEH_O_RETRO_LC_CLM_EST;

	private HtmlOutputLabel COMP_UI_M_CURR_CODE_DESC_LABEL;
	
	private HtmlOutputLabel COMP_FCEH_CCD_RESERVE_NO_LABEL;
	
	private HtmlOutputLabel COMP_FCEH_O_CCD_RESERVE_DT_LABEL;

	private HtmlInputText COMP_UI_M_CURR_CODE_DESC;
	
	private HtmlOutputLabel COMP_FCEH_CLAIM_CURR_CODE_LABEL;
	
	private int lastUpdatedRowIndex = 0;
	
	private int prevRowIndex = 0;
	

//	Muthu Added for Another Bean

	private HtmlInputText COMP_FCEH_CCD_RESERVE_NO;

	private HtmlInputText COMP_FCEH_CLAIM_CURR_CODE;

	private HtmlCalendar COMP_FCEH_O_CCD_RESERVE_DT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;
	
	private String filterByFCPCEH_CUST_CODE;
	
	private String filterByFCPCEH_O_FAC_PERC;
	
	private String filterByFCPCEH_O_FC_CLM_EST;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PILT011_COMPOSITE_ACTION compositeAction;

//	Muthu Added for Another Bean

	private PH_IL_FAC_CLAIM_PART_CUST_EST PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN;

	public PH_IL_FAC_CLAIM_PART_CUST_EST_ACTION() {
		PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = new PH_IL_FAC_CLAIM_PART_CUST_EST();
		handler = new CRUDHandler();
		//PH_IL_FAC_CLAIM_PART_CUST_EST_PRE_QUERY();
		//getPH_IL_FAC_CLAIM_PART_CUST_EST_Dtls();
		//PH_IL_FAC_CLAIM_PART_CUST_EST_POST_QUERY();
	}

	public HtmlOutputLabel getCOMP_FCPCEH_CUST_CODE_LABEL() {
		return COMP_FCPCEH_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_CUST_CODE() {
		return COMP_FCPCEH_CUST_CODE;
	}

	public void setCOMP_FCPCEH_CUST_CODE_LABEL(HtmlOutputLabel COMP_FCPCEH_CUST_CODE_LABEL) {
		this.COMP_FCPCEH_CUST_CODE_LABEL = COMP_FCPCEH_CUST_CODE_LABEL;
	}

	public void setCOMP_FCPCEH_CUST_CODE(HtmlInputText COMP_FCPCEH_CUST_CODE) {
		this.COMP_FCPCEH_CUST_CODE = COMP_FCPCEH_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_FAC_PERC_LABEL() {
		return COMP_FCPCEH_O_FAC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_FAC_PERC() {
		return COMP_FCPCEH_O_FAC_PERC;
	}

	public void setCOMP_FCPCEH_O_FAC_PERC_LABEL(HtmlOutputLabel COMP_FCPCEH_O_FAC_PERC_LABEL) {
		this.COMP_FCPCEH_O_FAC_PERC_LABEL = COMP_FCPCEH_O_FAC_PERC_LABEL;
	}

	public void setCOMP_FCPCEH_O_FAC_PERC(HtmlInputText COMP_FCPCEH_O_FAC_PERC) {
		this.COMP_FCPCEH_O_FAC_PERC = COMP_FCPCEH_O_FAC_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_FC_CLM_EST_LABEL() {
		return COMP_FCPCEH_O_FC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_FC_CLM_EST() {
		return COMP_FCPCEH_O_FC_CLM_EST;
	}

	public void setCOMP_FCPCEH_O_FC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCEH_O_FC_CLM_EST_LABEL) {
		this.COMP_FCPCEH_O_FC_CLM_EST_LABEL = COMP_FCPCEH_O_FC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCEH_O_FC_CLM_EST(HtmlInputText COMP_FCPCEH_O_FC_CLM_EST) {
		this.COMP_FCPCEH_O_FC_CLM_EST = COMP_FCPCEH_O_FC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_RETRO_PERC_LABEL() {
		return COMP_FCPCEH_O_RETRO_PERC_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_RETRO_PERC() {
		return COMP_FCPCEH_O_RETRO_PERC;
	}

	public void setCOMP_FCPCEH_O_RETRO_PERC_LABEL(HtmlOutputLabel COMP_FCPCEH_O_RETRO_PERC_LABEL) {
		this.COMP_FCPCEH_O_RETRO_PERC_LABEL = COMP_FCPCEH_O_RETRO_PERC_LABEL;
	}

	public void setCOMP_FCPCEH_O_RETRO_PERC(HtmlInputText COMP_FCPCEH_O_RETRO_PERC) {
		this.COMP_FCPCEH_O_RETRO_PERC = COMP_FCPCEH_O_RETRO_PERC;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL() {
		return COMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_RETRO_FC_CLM_EST() {
		return COMP_FCPCEH_O_RETRO_FC_CLM_EST;
	}

	public void setCOMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL) {
		this.COMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL = COMP_FCPCEH_O_RETRO_FC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCEH_O_RETRO_FC_CLM_EST(HtmlInputText COMP_FCPCEH_O_RETRO_FC_CLM_EST) {
		this.COMP_FCPCEH_O_RETRO_FC_CLM_EST = COMP_FCPCEH_O_RETRO_FC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_LC_CLM_EST_LABEL() {
		return COMP_FCPCEH_O_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_LC_CLM_EST() {
		return COMP_FCPCEH_O_LC_CLM_EST;
	}

	public void setCOMP_FCPCEH_O_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCEH_O_LC_CLM_EST_LABEL) {
		this.COMP_FCPCEH_O_LC_CLM_EST_LABEL = COMP_FCPCEH_O_LC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCEH_O_LC_CLM_EST(HtmlInputText COMP_FCPCEH_O_LC_CLM_EST) {
		this.COMP_FCPCEH_O_LC_CLM_EST = COMP_FCPCEH_O_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_NAME_LABEL() {
		return COMP_UI_M_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_NAME() {
		return COMP_UI_M_CUST_NAME;
	}

	public void setCOMP_UI_M_CUST_NAME_LABEL(HtmlOutputLabel COMP_UI_M_CUST_NAME_LABEL) {
		this.COMP_UI_M_CUST_NAME_LABEL = COMP_UI_M_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_CUST_NAME(HtmlInputText COMP_UI_M_CUST_NAME) {
		this.COMP_UI_M_CUST_NAME = COMP_UI_M_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL() {
		return COMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_FCPCEH_O_RETRO_LC_CLM_EST() {
		return COMP_FCPCEH_O_RETRO_LC_CLM_EST;
	}

	public void setCOMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL) {
		this.COMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL = COMP_FCPCEH_O_RETRO_LC_CLM_EST_LABEL;
	}

	public void setCOMP_FCPCEH_O_RETRO_LC_CLM_EST(HtmlInputText COMP_FCPCEH_O_RETRO_LC_CLM_EST) {
		this.COMP_FCPCEH_O_RETRO_LC_CLM_EST = COMP_FCPCEH_O_RETRO_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CURR_CODE_DESC() {
		return COMP_UI_M_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_CURR_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_CURR_CODE_DESC_LABEL = COMP_UI_M_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CURR_CODE_DESC(HtmlInputText COMP_UI_M_CURR_CODE_DESC) {
		this.COMP_UI_M_CURR_CODE_DESC = COMP_UI_M_CURR_CODE_DESC;
	}

	public PH_IL_FAC_CLAIM_PART_CUST_EST getPH_IL_FAC_CLAIM_PART_CUST_EST_BEAN() {
		return PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN;
	}

	public void setPH_IL_FAC_CLAIM_PART_CUST_EST_BEAN(PH_IL_FAC_CLAIM_PART_CUST_EST PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN) {
		this.PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN;
	}

	public void PH_IL_FAC_CLAIM_PART_CUST_EST_WHEN_NEW_BLOCK_INSTANCE(){
//		EXECUTE_QUERY;
	}
	/*public void PH_IL_FAC_CLAIM_PART_CUST_EST_PRE_QUERY(){
		PT_IL_FAC_CLAIM_EST claimEstBean = getPT_IL_FAC_CLAIM_EST_BEAN(); 
		PT_IL_FAC_CLAIM_PART_CUST_EST custEstBean = getPT_IL_FAC_CLAIM_PART_CUST_EST();
		PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_FCE_SYS_ID(Double.valueOf(claimEstBean.getFCE_SYS_ID()));//:PT_IL_FAC_CLAIM_EST.FCE_SYS_ID;
		PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_CUST_CODE(custEstBean.getFCPCE_CUST_CODE());//:PT_IL_FAC_CLAIM_PART_CUST_EST.FCPCE_CUST_CODE;
		
	}*/
	public PT_IL_FAC_CLAIM_EST getPT_IL_FAC_CLAIM_EST_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_EST_ACTION claimESTAction = (PT_IL_FAC_CLAIM_EST_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_EST_ACTION");
		PT_IL_FAC_CLAIM_EST claimEstBean = claimESTAction.getPT_IL_FAC_CLAIM_EST_BEAN();
		return claimEstBean;
	}
	public PT_IL_FAC_CLAIM_PART_CUST_EST getPT_IL_FAC_CLAIM_PART_CUST_EST(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION custESTAction = (PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_PART_CUST_EST_ACTION");
		PT_IL_FAC_CLAIM_PART_CUST_EST custEstBean= custESTAction.getPT_IL_FAC_CLAIM_PART_CUST_EST_BEAN();
		return custEstBean;
	}
	public List getPH_IL_FAC_CLAIM_EST(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PH_IL_FAC_CLAIM_EST_ACTION claimESTAction = (PH_IL_FAC_CLAIM_EST_ACTION) sessionMap.get("PILT011_PH_IL_FAC_CLAIM_EST_ACTION");
		return claimESTAction.getFacClaimList();
	}
	public void getPH_IL_FAC_CLAIM_EST_Dtl(PH_IL_FAC_CLAIM_PART_CUST_EST PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN){
		PT_IL_FAC_CLAIM_EST claimEstBean = getPT_IL_FAC_CLAIM_EST_BEAN();
		String query = "select FCEH_CCD_RESERVE_NO,FCEH_CLAIM_CURR_CODE,FCEH_O_CCD_RESERVE_DT from PH_IL_FAC_CLAIM_EST where FCEH_SYS_ID = "+claimEstBean.getFCE_SYS_ID();
		try {
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next()){
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCEH_CCD_RESERVE_NO(resultSet.getDouble("FCEH_CCD_RESERVE_NO"));
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCEH_CLAIM_CURR_CODE(resultSet.getString("FCEH_CLAIM_CURR_CODE"));
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCEH_O_CCD_RESERVE_DT(resultSet.getDate("FCEH_O_CCD_RESERVE_DT"));
			 }
			}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void PH_IL_FAC_CLAIM_PART_CUST_EST_POST_QUERY(){
		P_VAL_CUST();
		P_VAL_CURR();
	}
	public void P_VAL_CUST(){
		if (claimPartCustEST.size() > 0) {
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = claimPartCustEST.get(0);
		}
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCPCEH_CUST_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in3","STRING","IN","N");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",CommonUtils.getControlBean().getM_LANG_CODE());		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		List outParamList;
		try {
			outParamList = procHandler.execute(paramList, getConnection(), "P_VAL_CUST");
			OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setUI_M_CUST_NAME(planDescPar.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		getPH_IL_FAC_CLAIM_EST_Dtl(PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
	}

	public void P_VAL_CURR(){
		PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = claimPartCustEST.get(0); 
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.getFCEH_CLAIM_CURR_CODE());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT","");
		OracleParameter param3 = new OracleParameter("in3","STRING","IN","N");
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",CommonUtils.getControlBean().getM_LANG_CODE());		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		List outParamList;
		try {
			outParamList = procHandler.execute(paramList, getConnection(), "P_VAL_CURR");
			OracleParameter planDescPar =(OracleParameter)outParamList.get(0);
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setUI_M_CURR_CODE_DESC(planDescPar.getValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
//	public CTRL getControlBean(){
//		FacesContext faces = FacesContext.getCurrentInstance();
//		session = faces.getExternalContext().getSessionMap();
//		return (CTRL)session.get("ctrlbean");
//	}
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void getPH_IL_FAC_CLAIM_PART_CUST_EST_Dtls(){
		PT_IL_FAC_CLAIM_EST claimEstBean =  compositeAction.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN().getPT_IL_FAC_CLAIM_EST_BEAN();
		String query = "SELECT * FROM PH_IL_FAC_CLAIM_PART_CUST_EST WHERE FCPCEH_FCE_SYS_ID = "+claimEstBean.getFCE_SYS_ID()+" AND FCPCEH_CUST_CODE = '"+ session.get("CUSTOMER_CODE").toString()+"'";
		try {
			claimPartCustEST.clear();
			claimPartCustEST = handler.fetch(query, "com.iii.pel.forms.PILT011.PH_IL_FAC_CLAIM_PART_CUST_EST", getConnection());
			// Logic For Default Population
		
			Iterator<PH_IL_FAC_CLAIM_PART_CUST_EST> it = claimPartCustEST
					.iterator();
			while (it.hasNext()) {
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = it.next();
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(false);
				claimPartCustEST.add(PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
				//this.setPH_IL_FAC_CLAIM_PART_CUST_EST_BEAN(claimPartCustEST
						//.get(0));
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(
						true);
			}
			// actionBean.setDataTableList(outputList);
			/*if (claimPartCustEST.size() > 0) {
				claimPartCustEST.add(PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
				//this.setPH_IL_FAC_CLAIM_PART_CUST_EST_BEAN(claimPartCustEST
						//.get(0));
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(
						true);*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<PH_IL_FAC_CLAIM_PART_CUST_EST> getClaimPartCustEST() {
		return claimPartCustEST;
	}

	public void setClaimPartCustEST(
			List<PH_IL_FAC_CLAIM_PART_CUST_EST> claimPartCustEST) {
		this.claimPartCustEST = claimPartCustEST;
	}

	public UIDataTable getUiDataTable() {
		return uiDataTable;
	}

	public void setUiDataTable(UIDataTable uiDataTable) {
		this.uiDataTable = uiDataTable;
	}
	public void checkBoxStatus(ActionEvent actionEvent){

	}

	public HtmlInputText getCOMP_FCEH_CCD_RESERVE_NO() {
		return COMP_FCEH_CCD_RESERVE_NO;
	}

	public void setCOMP_FCEH_CCD_RESERVE_NO(HtmlInputText comp_fceh_ccd_reserve_no) {
		COMP_FCEH_CCD_RESERVE_NO = comp_fceh_ccd_reserve_no;
	}

	public HtmlInputText getCOMP_FCEH_CLAIM_CURR_CODE() {
		return COMP_FCEH_CLAIM_CURR_CODE;
	}

	public void setCOMP_FCEH_CLAIM_CURR_CODE(HtmlInputText comp_fceh_claim_curr_code) {
		COMP_FCEH_CLAIM_CURR_CODE = comp_fceh_claim_curr_code;
	}

	public HtmlCalendar getCOMP_FCEH_O_CCD_RESERVE_DT() {
		return COMP_FCEH_O_CCD_RESERVE_DT;
	}

	public void setCOMP_FCEH_O_CCD_RESERVE_DT(
			HtmlCalendar comp_fceh_o_ccd_reserve_dt) {
		COMP_FCEH_O_CCD_RESERVE_DT = comp_fceh_o_ccd_reserve_dt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public String UI_M_BUT_MAIN_BUTTON_PRESSED(){
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.remove("CUSTOMER_CODE");
		return "fac_estimate";
	}
	
	public void getDetails() {
		try {
			resetSelectedRow();
			if (claimPartCustEST.size() != 0) {				
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = (PH_IL_FAC_CLAIM_PART_CUST_EST) uiDataTable.getRowData();
			}	
			
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(true);
			resetAllComponent();			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
		
	private void resetSelectedRow() {
			Iterator<PH_IL_FAC_CLAIM_PART_CUST_EST> iterator = claimPartCustEST.iterator();
			while (iterator.hasNext()) {
				iterator.next().setRowSelected(false);
			}
		}
	
	private void resetAllComponent()
	{
		COMP_FCEH_CCD_RESERVE_NO.resetValue();
		COMP_FCPCEH_CUST_CODE.resetValue();
		COMP_FCPCEH_O_FAC_PERC.resetValue();
		COMP_FCPCEH_O_FC_CLM_EST.resetValue();
		COMP_FCPCEH_O_RETRO_PERC.resetValue();
		COMP_FCPCEH_O_RETRO_FC_CLM_EST.resetValue();
		COMP_FCEH_O_CCD_RESERVE_DT.resetValue();
		COMP_FCPCEH_O_LC_CLM_EST.resetValue();
		COMP_UI_M_CUST_NAME.resetValue();
		COMP_FCPCEH_O_RETRO_LC_CLM_EST.resetValue();
		COMP_FCEH_CLAIM_CURR_CODE.resetValue();
		COMP_UI_M_CURR_CODE_DESC.resetValue();
	}
	
	public void gridtabListener(){
		
		int currRowIndex = getUiDataTable().getRowIndex();
		int rowUpdated = 0;
		PH_IL_FAC_CLAIM_PART_CUST_EST gridValueBean = null;
		
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevRowIndex)
				{
					if(currRowIndex != prevRowIndex){
						// Get the bean based on row index
						gridValueBean = (PH_IL_FAC_CLAIM_PART_CUST_EST)claimPartCustEST.get(prevRowIndex);
						
							// Update the record to database
							if(gridValueBean.getROWID()!=null)
							{
								rowUpdated = 0; //dataGridDelegate.updateData(gridValueBean);
								getErrorMap().put("somekey", rowUpdated+" record updated.");
								getErrorMap().put("current", rowUpdated+" record updated.");
							}else
							{
								rowUpdated = 0; //dataGridDelegate.updateData(gridValueBean);
								getErrorMap().put("somekey", rowUpdated+" record inserted.");
								getErrorMap().put("current", rowUpdated+" record inserted.");
								
							}
						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return ;
	}
	
	public void onLoad(PhaseEvent event){
		if (isBlockFlag()) {
			try {
				executeQuery();
				if (getClaimPartCustEST().size() != 0) {
					PH_IL_FAC_CLAIM_PART_CUST_EST PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = getClaimPartCustEST()
							.get(0);
					PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setRowSelected(true);
					compositeAction.getPH_IL_FAC_CLAIM_PART_CUST_EST_ACTION_BEAN().setPH_IL_FAC_CLAIM_PART_CUST_EST_BEAN(PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("ON_LOAD", e.getMessage());
			}
		    setBlockFlag(false);	
		}
		
	}
	
	public void executeQuery() throws Exception{
		PH_IL_FAC_CLAIM_PART_CUST_EST PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = null;
		String selectQuery = "SELECT * FROM PH_IL_FAC_CLAIM_PART_CUST_EST WHERE FCPCEH_FCE_SYS_ID = ? AND FCPCEH_CUST_CODE = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,
					new Object[] { compositeAction
							.getPT_IL_FAC_CLAIM_EST_ACTION_BEAN()
							.getPT_IL_FAC_CLAIM_EST_BEAN().getFCE_SYS_ID(), 
							CommonUtils.getGlobalVariable("CUSTOMER_CODE")});
			if(getClaimPartCustEST().size() >0){
				getClaimPartCustEST().clear();
			}
			claimPartCustEST = new ArrayList<PH_IL_FAC_CLAIM_PART_CUST_EST>();
			while(resultSet.next())
			{
				PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN = new PH_IL_FAC_CLAIM_PART_CUST_EST();
			/*PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setROWID(resultSet
					.getString("ROWID"));*/
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_SYS_ID(resultSet
					.getLong("FCPCEH_SYS_ID"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_FCE_SYS_ID(resultSet
					.getLong("FCPCEH_FCE_SYS_ID"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_FPCU_SYS_ID(resultSet
					.getLong("FCPCEH_FPCU_SYS_ID"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_CUST_CODE(resultSet
					.getString("FCPCEH_CUST_CODE"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_O_FAC_PERC(resultSet
					.getDouble("FCPCEH_O_FAC_PERC"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_N_FAC_PERC(resultSet
					.getDouble("FCPCEH_N_FAC_PERC"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_O_FC_CLM_EST(resultSet
					.getDouble("FCPCEH_O_FC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_N_FC_CLM_EST(resultSet
					.getDouble("FCPCEH_N_FC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_O_LC_CLM_EST(resultSet
					.getDouble("FCPCEH_O_LC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_N_LC_CLM_EST(resultSet
					.getDouble("FCPCEH_N_LC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_O_RETRO_PERC(resultSet
					.getDouble("FCPCEH_O_RETRO_PERC"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_N_RETRO_PERC(resultSet
					.getDouble("FCPCEH_N_RETRO_PERC"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN
					.setFCPCEH_O_RETRO_FC_CLM_EST(resultSet
							.getDouble("FCPCEH_O_RETRO_FC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN
					.setFCPCEH_N_RETRO_FC_CLM_EST(resultSet
							.getDouble("FCPCEH_N_RETRO_FC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN
					.setFCPCEH_O_RETRO_LC_CLM_EST(resultSet
							.getDouble("FCPCEH_O_RETRO_LC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN
					.setFCPCEH_N_RETRO_LC_CLM_EST(resultSet
							.getDouble("FCPCEH_N_RETRO_LC_CLM_EST"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_CR_UID(resultSet
					.getString("FCPCEH_CR_UID"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_CR_DT(resultSet
					.getDate("FCPCEH_CR_DT"));
			PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN.setFCPCEH_CCD_RESERVE_NO(resultSet
					.getInt("FCPCEH_CCD_RESERVE_NO"));
			getClaimPartCustEST().add(PH_IL_FAC_CLAIM_PART_CUST_EST_BEAN);
			
			}
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * @return the filterByFCPCEH_CUST_CODE
	 */
	public String getFilterByFCPCEH_CUST_CODE() {
		return filterByFCPCEH_CUST_CODE;
	}

	/**
	 * @param filterByFCPCEH_CUST_CODE the filterByFCPCEH_CUST_CODE to set
	 */
	public void setFilterByFCPCEH_CUST_CODE(String filterByFCPCEH_CUST_CODE) {
		this.filterByFCPCEH_CUST_CODE = filterByFCPCEH_CUST_CODE;
	}

	/**
	 * @return the filterByFCPCEH_O_FAC_PERC
	 */
	public String getFilterByFCPCEH_O_FAC_PERC() {
		return filterByFCPCEH_O_FAC_PERC;
	}

	/**
	 * @param filterByFCPCEH_O_FAC_PERC the filterByFCPCEH_O_FAC_PERC to set
	 */
	public void setFilterByFCPCEH_O_FAC_PERC(String filterByFCPCEH_O_FAC_PERC) {
		this.filterByFCPCEH_O_FAC_PERC = filterByFCPCEH_O_FAC_PERC;
	}

	/**
	 * @return the filterByFCPCEH_O_FC_CLM_EST
	 */
	public String getFilterByFCPCEH_O_FC_CLM_EST() {
		return filterByFCPCEH_O_FC_CLM_EST;
	}

	/**
	 * @param filterByFCPCEH_O_FC_CLM_EST the filterByFCPCEH_O_FC_CLM_EST to set
	 */
	public void setFilterByFCPCEH_O_FC_CLM_EST(String filterByFCPCEH_O_FC_CLM_EST) {
		this.filterByFCPCEH_O_FC_CLM_EST = filterByFCPCEH_O_FC_CLM_EST;
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

	/**
	 * @return the cOMP_FCEH_CCD_RESERVE_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_FCEH_CCD_RESERVE_NO_LABEL() {
		return COMP_FCEH_CCD_RESERVE_NO_LABEL;
	}

	/**
	 * @param comp_fceh_ccd_reserve_no_label the cOMP_FCEH_CCD_RESERVE_NO_LABEL to set
	 */
	public void setCOMP_FCEH_CCD_RESERVE_NO_LABEL(
			HtmlOutputLabel comp_fceh_ccd_reserve_no_label) {
		COMP_FCEH_CCD_RESERVE_NO_LABEL = comp_fceh_ccd_reserve_no_label;
	}

	/**
	 * @return the cOMP_FCEH_O_CCD_RESERVE_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_FCEH_O_CCD_RESERVE_DT_LABEL() {
		return COMP_FCEH_O_CCD_RESERVE_DT_LABEL;
	}

	/**
	 * @param comp_fceh_o_ccd_reserve_dt_label the cOMP_FCEH_O_CCD_RESERVE_DT_LABEL to set
	 */
	public void setCOMP_FCEH_O_CCD_RESERVE_DT_LABEL(
			HtmlOutputLabel comp_fceh_o_ccd_reserve_dt_label) {
		COMP_FCEH_O_CCD_RESERVE_DT_LABEL = comp_fceh_o_ccd_reserve_dt_label;
	}

	/**
	 * @return the cOMP_FCEH_CLAIM_CURR_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_FCEH_CLAIM_CURR_CODE_LABEL() {
		return COMP_FCEH_CLAIM_CURR_CODE_LABEL;
	}

	/**
	 * @param comp_fceh_claim_curr_code_label the cOMP_FCEH_CLAIM_CURR_CODE_LABEL to set
	 */
	public void setCOMP_FCEH_CLAIM_CURR_CODE_LABEL(
			HtmlOutputLabel comp_fceh_claim_curr_code_label) {
		COMP_FCEH_CLAIM_CURR_CODE_LABEL = comp_fceh_claim_curr_code_label;
	}

	public PILT011_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT011_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

}
