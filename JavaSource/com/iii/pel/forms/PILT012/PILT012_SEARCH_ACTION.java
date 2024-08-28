package com.iii.pel.forms.PILT012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PILT012_SEARCH_ACTION extends CommonAction{
	
	private PILT012_SEARCH_BEAN searchBean;
	private List<PILT012_SEARCH_BEAN> dataTableBean;
	private HtmlInputText COMP_RCR_POL_NO;
	private HtmlInputText COMP_RCR_CLM_NO;
	private UIData dataTable;

	public String updateButtonAction(String rowId) {
		PILT012_COMPOSITE_ACTION compositeAction = new PILT012_COMPOSITE_ACTION();
		String outcome = null;
		FacesContext context = FacesContext.getCurrentInstance();
		Map requestParameterMap = context.getExternalContext().getRequestParameterMap();
	
		CommonUtils.setGlobalObject("PILT012_COMPOSITE_ACTION",compositeAction);
		compositeAction.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN().getPS_IL_RI_CLAIM_REG_1_BEAN().setROWID(rowId);
		outcome = "PILT012_PS_IL_RI_CLAIM_REG_1";
		return outcome;
    }

    public String insertButtonAction() {
    	PILT012_COMPOSITE_ACTION compositeAction = new PILT012_COMPOSITE_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILT012_COMPOSITE_ACTION",
			compositeAction);
		outcome = "PILT012_PS_IL_RI_CLAIM_REG_1";
		return outcome;
	
	    }
	
	    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

	public PILT012_SEARCH_ACTION(){
		searchBean = new PILT012_SEARCH_BEAN();
	}

	public PILT012_SEARCH_BEAN getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(PILT012_SEARCH_BEAN searchBean) {
		this.searchBean = searchBean;
	}

	public List<PILT012_SEARCH_BEAN> getDataTableBean() {
		return dataTableBean;
	}

	public void setDataTableBean(List<PILT012_SEARCH_BEAN> dataTableBean) {
		this.dataTableBean = dataTableBean;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_RCR_POL_NO() {
		return COMP_RCR_POL_NO;
	}

	public void setCOMP_RCR_POL_NO(HtmlInputText comp_rcr_pol_no) {
		COMP_RCR_POL_NO = comp_rcr_pol_no;
	}

	public HtmlInputText getCOMP_RCR_CLM_NO() {
		return COMP_RCR_CLM_NO;
	}

	public void setCOMP_RCR_CLM_NO(HtmlInputText comp_rcr_clm_no) {
		COMP_RCR_CLM_NO = comp_rcr_clm_no;
	}

	public String fetch(){
		PILT012_SEARCH_DELEGATE delegate = new PILT012_SEARCH_DELEGATE();
		System.out.println("I am in fetch record");
		this.dataTableBean = delegate.fetchMasterBlock(this);
		return null;
	}

	/*public String insert() throws DBException{
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILT012_PS_IL_RI_CLAIM_REG_1_ACTION")!=null)
		{
			session.removeAttribute("PILT012_PS_IL_RI_CLAIM_REG_1_ACTION");
		}
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "INSERT");
		sessionMap.put("CLIENT_CON", CommonUtils.getConnection());
		return "PILT012_PS_IL_RI_CLAIM_REG_1";
	}*/

	public String fetchMasterRecord(){
		FacesContext context=FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getRequestParameterMap();
		String rowId=(String)map.get("ROWID");
		String RCR_POL_NO = (String)map.get("RCR_POL_NO");
		String RCR_CLM_NO= (String)map.get("RCR_CLM_NO");
		String RCR_CLM_COVER_CODE=(String)map.get("RCR_CLM_COVER_CODE");
		
		String selectQuery="";
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PS_IL_RI_CLAIM_REG_1_ACTION sessionBean=(PS_IL_RI_CLAIM_REG_1_ACTION)session.getAttribute("PS_IL_RI_CLAIM_REG_1_ACTION");
		try{
			if(!"null".equalsIgnoreCase(RCR_POL_NO) && !"null".equalsIgnoreCase(RCR_CLM_NO) && !"null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				"RCR_POL_NO='"+RCR_POL_NO+"' and  RCR_CLM_NO='"+RCR_CLM_NO+"' and RCR_CLM_COVER_CODE='"+RCR_CLM_COVER_CODE+"'";
			}else if("null".equalsIgnoreCase(RCR_POL_NO) && !"null".equalsIgnoreCase(RCR_CLM_NO) && !"null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				" RCR_CLM_NO='"+RCR_CLM_NO+"' and RCR_CLM_COVER_CODE='"+RCR_CLM_COVER_CODE+"'";
			}else if(!"null".equalsIgnoreCase(RCR_POL_NO) && "null".equalsIgnoreCase(RCR_CLM_NO) && !"null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				"RCR_POL_NO='"+RCR_POL_NO+"' and RCR_CLM_COVER_CODE='"+RCR_CLM_COVER_CODE+"'";
			}else if(!"null".equalsIgnoreCase(RCR_POL_NO) && !"null".equalsIgnoreCase(RCR_CLM_NO) && "null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				"RCR_POL_NO='"+RCR_POL_NO+"' and  RCR_CLM_NO='"+RCR_CLM_NO+"'";
		    }else if(!"null".equalsIgnoreCase(RCR_POL_NO) && "null".equalsIgnoreCase(RCR_CLM_NO) && "null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				"RCR_POL_NO='"+RCR_POL_NO+"'";
			}else if("null".equalsIgnoreCase(RCR_POL_NO) && !"null".equalsIgnoreCase(RCR_CLM_NO) && "null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				" RCR_CLM_NO='"+RCR_CLM_NO+"'";
			}else if("null".equalsIgnoreCase(RCR_POL_NO) && "null".equalsIgnoreCase(RCR_CLM_NO) && !"null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID='"+rowId+"' AND " +
				" RCR_CLM_COVER_CODE='"+RCR_CLM_COVER_CODE+"'";
			}else if("null".equalsIgnoreCase(RCR_POL_NO) && "null".equalsIgnoreCase(RCR_CLM_NO) && "null".equalsIgnoreCase(RCR_CLM_COVER_CODE)){
				selectQuery = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG";
			}
			System.out.println("PS_IL_RI_CLAIM_REG_1_SearchAction.fetchMasterRecord()---["+selectQuery+"]");
			List list = getHandler().fetch(selectQuery, "com.iii.pel.forms.PILT012.PS_IL_RI_CLAIM_REG_1", CommonUtils.getConnection());
			PS_IL_RI_CLAIM_REG_1 valueBean=(PS_IL_RI_CLAIM_REG_1)list.get(0);
			System.out.println("Testtttttttt  "+valueBean);
			ELResolver resolver = context.getApplication().getELResolver();
			PS_IL_RI_CLAIM_REG_1_ACTION actionBean= (PS_IL_RI_CLAIM_REG_1_ACTION)resolver.getValue(context.getELContext(), null, "PILT012_PS_IL_RI_CLAIM_REG_1_ACTION");
			if(actionBean == null) {
				System.out.println("bean null");
			}
//			valueBean.setUI_M_MAIN_ACNT_NAME(mainAccDesc(valueBean.getFAS_MAIN_ACNT_CODE()));
//			valueBean.setUI_M_SUB_ACNT_NAME(subAccDesc(valueBean.getFAS_MAIN_ACNT_CODE(), valueBean.getFAS_SUB_ACNT_CODE()));
//			valueBean.setUI_M_DIVN_NAME(branchAccDesc(valueBean.getFAS_DIVN_CODE()));
//			valueBean.setUI_M_DEPT_NAME(deptAccDesc(valueBean.getFAS_DIVN_CODE(), valueBean.getFAS_DEPT_CODE()));
//			valueBean.setUI_M_ANLY_NAME(analysisCode1Desc(valueBean.getFAS_ANLY_CODE_1()));
//			valueBean.setUI_M_ANLY_NAME_1(analysisCode2Desc(valueBean.getFAS_ANLY_CODE_2()));
			actionBean.setPS_IL_RI_CLAIM_REG_1_BEAN(valueBean);
			Map sessionMap = context.getExternalContext().getSessionMap();
			sessionMap.put("PILT012_PS_IL_RI_CLAIM_REG_1_ACTION", actionBean);
			postQuery(actionBean);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "PILT012_PS_IL_RI_CLAIM_REG_1";
	}
	
	public String postQuery(PS_IL_RI_CLAIM_REG_1_ACTION actionBean)throws Exception{
		try{
//			Map m = getSessionMap();
//			PS_IL_RI_CLAIM_REG_1_ACTION psIlRiClaimRegAction = (PS_IL_RI_CLAIM_REG_1_ACTION) m.get("PILT012_PS_IL_RI_CLAIM_REG_1_ACTION");
			String query="SELECT POL_CUST_CURR_CODE FROM PT_IL_POLICY WHERE POL_NO = ?";
			String query1="SELECT NVL(RCA_RI_CLM_CLOSE_FLAG,'N') FROM PT_IL_RI_CLAIM_ALLOC " +
					"WHERE RCA_CLM_SYS_ID = ? AND  RCA_CLAIM_COVER_CODE  = ? AND RCA_DT = ? ";
			String status=null;
			Object[] values = new Object[1];
			Object[] values1 = new Object[3];
			values[0] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_POL_NO();
			ResultSet rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection(), values);
			while(rs.next()){
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_POL_CUST_CURR_CODE(rs.getString("POL_CUST_CURR_CODE"));
			}
//			P_SET_FC_NUM_FMT_MASK(:PS_IL_RI_CLAIM_REG_1.M_POL_CUST_CURR_CODE); 
			rs.close();
			values1[0] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID();
			values1[1] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE();
			values1[2] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_DT();
			ResultSet rs1 = getHandler().executeSelectStatement(query1, CommonUtils.getConnection(), values1);
			while(rs1.next()){
//				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setM_RI_CLOSE(rs.getString("NVL(RCA_RI_CLM_CLOSE_FLAG,'N')"));
				status=rs1.getString(1);
			}
			System.out.println("******: "+actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getUI_M_RI_CLOSE());
			/*IF M_RI_CLOSE_FLAG = 'N'  THEN
	        	SET_ITEM_PROPERTY('M_BUT_CLOSE',ENABLED,PROPERTY_TRUE);
	        	:DUMMY.M_RI_CLOSE  := '           ';
	     	ELSE
	        	L_SET_CLOSE_REC_ATTRB('PS_IL_RI_CLAIM_REG');
	        	:DUMMY.M_RI_CLOSE  := 'Claim RI Closed';
	        	SET_ITEM_PROPERTY('M_BUT_CLOSE',ENABLED,PROPERTY_FALSE);
	     	END IF;*/
			rs1.close();
			if(status.equalsIgnoreCase("N")){
//				actionBean.getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_RI_CLOSE(status);
			}else{
//				L_SET_CLOSE_REC_ATTRB('PS_IL_RI_CLAIM_REG');
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_RI_CLOSE("Claim RI Closed");
//				actionBean.getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
			}
			ResultSet resultSet = null;
			String Cover_Query = "SELECT COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE = ? ";
			resultSet = new CRUDHandler().executeSelectStatement(Cover_Query, CommonUtils.getConnection(),
					new Object[] {actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE()});
			if (resultSet.next()) {
				actionBean.getCOMP_M_COVER_DESC().setSubmittedValue(resultSet.getString(1));
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_COVER_DESC(resultSet.getString(1));
			}
			CommonUtils.closeCursor(resultSet);
			WHEN_NEW_RECORD_INSTACE(actionBean);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null; 
	}
	
	public void WHEN_NEW_RECORD_INSTACE(PS_IL_RI_CLAIM_REG_1_ACTION PS_IL_RI_CLAIM_REG_1_ACTION_BEAN)throws Exception {
		PS_IL_RI_CLAIM_REG_1 PS_IL_RI_CLAIM_REG_1_BEAN = PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getPS_IL_RI_CLAIM_REG_1_BEAN();
		String M_POL_FAC_YN	= null;
		String C1 ="SELECT NVL(POL_FAC_YN,'N') FROM   PT_IL_POLICY " +
				"WHERE  POL_NO = ?  ";
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(C1, con, new Object[]{PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_POL_NO()});
			while(rs.next()){
				M_POL_FAC_YN = rs.getString(1);
			}
		  if(PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_POL_NO()==null || PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_CLM_NO()==null || 
		     PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_CLM_COVER_CODE() == null || !"Y".equals(M_POL_FAC_YN) )
			  PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_DETAILS().setDisabled(true);
		  else
			  PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_DETAILS().setDisabled(false);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		  
	}

	/*public String mainAccDesc(String mainAccNo) throws Exception{
		String desc=null;
		PreparedStatement pstmt = CommonUtils.getConnection().prepareStatement("SELECT MAIN_ACNT_CODE, MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25" +
								  "AND MAIN_ACNT_CODE = ?");
		pstmt.setString(1, mainAccNo);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			desc = rs.getString("MAIN_ACNT_NAME");
		}
		rs.close();
		return desc;
	}*/
	
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}


}
