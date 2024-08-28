package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PH_IL_FAC_CLAIM_EST_ACTION {

	private HtmlOutputLabel COMP_FCEH_CCD_RESERVE_NO_LABEL;

	private HtmlInputText COMP_FCEH_CCD_RESERVE_NO;

	private HtmlOutputLabel COMP_FCEH_O_CCD_RESERVE_DT_LABEL;

	private HtmlCalendar COMP_FCEH_O_CCD_RESERVE_DT;

	private HtmlOutputLabel COMP_FCEH_CLAIM_CURR_CODE_LABEL;

	private HtmlInputText COMP_FCEH_CLAIM_CURR_CODE;

	private PH_IL_FAC_CLAIM_EST PH_IL_FAC_CLAIM_EST_BEAN;
	
	private HtmlCommandButton testButton;

	private List<PH_IL_FAC_CLAIM_EST>  facClaimList= new ArrayList<PH_IL_FAC_CLAIM_EST>();
	private CRUDHandler handler = null;
	private Connection connection = null;
	public PILT011_COMPOSITE_ACTION compositeAction;
	
	public PH_IL_FAC_CLAIM_EST_ACTION() {
		PH_IL_FAC_CLAIM_EST_BEAN = new PH_IL_FAC_CLAIM_EST();
		handler = new CRUDHandler();
		//PH_IL_FAC_CLAIM_EST_WHEN_NEW_BLOCK_INSTANCE();
		//FCEH_CLAIM_CURR_CODE_WHEN_NEW_ITEM_INSTANCE();
		//PH_IL_FAC_CLAIM_EST_PRE_QUERY();
	}
	
	public PH_IL_FAC_CLAIM_EST returnPH_IL_FAC_CLAIM_EST(){
		return (PH_IL_FAC_CLAIM_EST)facClaimList.get(0);
	}
	
	public HtmlOutputLabel getCOMP_FCEH_CCD_RESERVE_NO_LABEL() {
		return COMP_FCEH_CCD_RESERVE_NO_LABEL;
	}

	public HtmlInputText getCOMP_FCEH_CCD_RESERVE_NO() {
		return COMP_FCEH_CCD_RESERVE_NO;
	}

	public void setCOMP_FCEH_CCD_RESERVE_NO_LABEL(HtmlOutputLabel COMP_FCEH_CCD_RESERVE_NO_LABEL) {
		this.COMP_FCEH_CCD_RESERVE_NO_LABEL = COMP_FCEH_CCD_RESERVE_NO_LABEL;
	}

	public void setCOMP_FCEH_CCD_RESERVE_NO(HtmlInputText COMP_FCEH_CCD_RESERVE_NO) {
		this.COMP_FCEH_CCD_RESERVE_NO = COMP_FCEH_CCD_RESERVE_NO;
	}

	public HtmlOutputLabel getCOMP_FCEH_O_CCD_RESERVE_DT_LABEL() {
		return COMP_FCEH_O_CCD_RESERVE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FCEH_O_CCD_RESERVE_DT() {
		return COMP_FCEH_O_CCD_RESERVE_DT;
	}

	public void setCOMP_FCEH_O_CCD_RESERVE_DT_LABEL(HtmlOutputLabel COMP_FCEH_O_CCD_RESERVE_DT_LABEL) {
		this.COMP_FCEH_O_CCD_RESERVE_DT_LABEL = COMP_FCEH_O_CCD_RESERVE_DT_LABEL;
	}

	public void setCOMP_FCEH_O_CCD_RESERVE_DT(HtmlCalendar COMP_FCEH_O_CCD_RESERVE_DT) {
		this.COMP_FCEH_O_CCD_RESERVE_DT = COMP_FCEH_O_CCD_RESERVE_DT;
	}

	public HtmlOutputLabel getCOMP_FCEH_CLAIM_CURR_CODE_LABEL() {
		return COMP_FCEH_CLAIM_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FCEH_CLAIM_CURR_CODE() {
		return COMP_FCEH_CLAIM_CURR_CODE;
	}

	public void setCOMP_FCEH_CLAIM_CURR_CODE_LABEL(HtmlOutputLabel COMP_FCEH_CLAIM_CURR_CODE_LABEL) {
		this.COMP_FCEH_CLAIM_CURR_CODE_LABEL = COMP_FCEH_CLAIM_CURR_CODE_LABEL;
	}

	public void setCOMP_FCEH_CLAIM_CURR_CODE(HtmlInputText COMP_FCEH_CLAIM_CURR_CODE) {
		this.COMP_FCEH_CLAIM_CURR_CODE = COMP_FCEH_CLAIM_CURR_CODE;
	}

	public PH_IL_FAC_CLAIM_EST getPH_IL_FAC_CLAIM_EST_BEAN() {
		return PH_IL_FAC_CLAIM_EST_BEAN;
	}

	public void setPH_IL_FAC_CLAIM_EST_BEAN(PH_IL_FAC_CLAIM_EST PH_IL_FAC_CLAIM_EST_BEAN) {
		this.PH_IL_FAC_CLAIM_EST_BEAN = PH_IL_FAC_CLAIM_EST_BEAN;
	}
	
	public void PH_IL_FAC_CLAIM_EST_WHEN_NEW_BLOCK_INSTANCE(){
		PT_IL_FAC_CLAIM_EST claimEstBean = getPT_IL_FAC_CLAIM_EST_BEAN();
		
		String query = "SELECT * FROM PH_IL_FAC_CLAIM_EST WHERE FCEH_SYS_ID = "+ claimEstBean.getFCE_SYS_ID();
		try {
			facClaimList = handler.fetch(query, "com.iii.pel.forms.PILT011.PH_IL_FAC_CLAIM_EST", getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	


	public void PH_IL_FAC_CLAIM_EST_PRE_QUERY(){
		PT_IL_FAC_CLAIM_EST claimEstBean = getPT_IL_FAC_CLAIM_EST_BEAN();
		PH_IL_FAC_CLAIM_EST_BEAN.setFCEH_CLAIM_SYS_ID(claimEstBean.getFCE_CLAIM_SYS_ID());//:PT_IL_FAC_CLAIM_EST.FCE_CLAIM_SYS_ID;
		PH_IL_FAC_CLAIM_EST_BEAN.setFCEH_CCD_COVER_CODE(claimEstBean.getFCE_CCD_COVER_CODE());//:PT_IL_FAC_CLAIM_EST.FCE_CCD_COVER_CODE;
	}
	
	public PT_IL_FAC_CLAIM_EST getPT_IL_FAC_CLAIM_EST_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_FAC_CLAIM_EST_ACTION claimESTAction = (PT_IL_FAC_CLAIM_EST_ACTION) sessionMap.get("PILT011_PT_IL_FAC_CLAIM_EST_ACTION");
		PT_IL_FAC_CLAIM_EST claimEstBean= claimESTAction.getPT_IL_FAC_CLAIM_EST_BEAN();
		return claimEstBean;
	}
	
	public void FCEH_CLAIM_CURR_CODE_WHEN_NEW_ITEM_INSTANCE(){
//		GO_ITEM('PH_IL_FAC_CLAIM_PART_CUST_EST.FCPCEH_CUST_CODE');
	}
	
	public void callForm(PhaseEvent ae){
		//return "claim_part_cust_est";
	}
	
	public void M_BUT_MAIN_WHEN_BUTTON_PRESSED(){
//		GO_ITEM('PT_IL_FAC_CLAIM_PART_CUST_EST.FCPCE_CUST_CODE');
	}

	public List<PH_IL_FAC_CLAIM_EST> getFacClaimList() {
		return facClaimList;
	}

	public void setFacClaimList(List<PH_IL_FAC_CLAIM_EST> facClaimList) {
		this.facClaimList = facClaimList;
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

	public HtmlCommandButton getTestButton() {
		return testButton;
	}

	public void setTestButton(HtmlCommandButton testButton) {
		this.testButton = testButton;
	}

}
