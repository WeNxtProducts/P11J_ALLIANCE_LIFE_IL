package com.iii.pel.forms.PILM203;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.UIDatascroller;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM203_SEARCH_ACTION_BEAN extends CommonAction {

	private UIInput COVER_CODE;
	private HtmlAjaxCommandButton SEARCH_BUTTON;
	private HtmlAjaxCommandButton INSERT_BUTTON;

	private UIDataTable COMP_DATATABLE;
	private UIDatascroller COMP_DATASCROLLER;

	private List<PM_IL_COVER> LIST_DATATABLE ;

	private PILM203_SEARCH_VALUE_BEAN searchValueBean;

	public PILM203_SEARCH_ACTION_BEAN() {
		searchValueBean = new PILM203_SEARCH_VALUE_BEAN();
		LIST_DATATABLE = new ArrayList<PM_IL_COVER>();
	}

	public UIInput getCOVER_CODE() {
		return COVER_CODE;
	}
	public void setCOVER_CODE(UIInput cover_code) {
		COVER_CODE = cover_code;
	}
	public HtmlAjaxCommandButton getSEARCH_BUTTON() {
		return SEARCH_BUTTON;
	}
	public void setSEARCH_BUTTON(HtmlAjaxCommandButton search_button) {
		SEARCH_BUTTON = search_button;
	}

	public UIDataTable getCOMP_DATATABLE() {
		return COMP_DATATABLE;
	}

	public void setCOMP_DATATABLE(UIDataTable comp_datatable) {
		COMP_DATATABLE = comp_datatable;
	}

	public UIDatascroller getCOMP_DATASCROLLER() {
		return COMP_DATASCROLLER;
	}

	public void setCOMP_DATASCROLLER(UIDatascroller comp_datascroller) {
		COMP_DATASCROLLER = comp_datascroller;
	}

	public List<PM_IL_COVER> getLIST_DATATABLE() {
		return LIST_DATATABLE;
	}

	public void setLIST_DATATABLE(List<PM_IL_COVER> list_datatable) {
		LIST_DATATABLE = list_datatable;
	}

	public String insert() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map sess = context.getExternalContext().getSessionMap();
		sess.put("CURRENT_MODE", "INSERT");
		
		return "PILM203_insertMode";
	}

	public void search() {
		String coverCode = getSearchValueBean().getCOVER_CODE();
//		String submitted = getCOVER_CODE().getSubmittedValue().toString();
		System.out.println("cover code "+coverCode);

		CRUDHandler handler = new CRUDHandler();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			Connection con = CommonUtils.getConnection();
			String query = null;
			/* [BugId:TRACK_PREMIAGDC_GL.10.5-00190: System should list only 'Medical Basic' type D covers; Fixed by : Mallika.S, 02-Apr-2009 */
			//String mainQuery = "SELECT TAB1.ROWID, TAB1.* FROM PM_IL_COVER TAB1 WHERE TAB1.COVER_MEDICAL_YN='Y' {0}";
			String mainQuery = "SELECT TAB1.ROWID, TAB1.* FROM PM_IL_COVER TAB1 WHERE TAB1.COVER_TYPE='D' {0}";
			StringBuffer whereClause = new StringBuffer();

			/*if(coverCode != null && !coverCode.equals("")) {
				String str = "WHERE COVER_CODE LIKE '"+coverCode.toUpperCase()+"%'";
				whereClause.append(str);
			}
			if(whereClause != null) {
				query = mainQuery + whereClause.toString();
			}else {
				query = mainQuery ;
			}*/
			
			if(coverCode == null && coverCode.equals("")) {
				mainQuery = mainQuery.replace("{0}", "");
			}else{
				mainQuery = mainQuery.replace("{0}", " AND COVER_CODE LIKE '"+coverCode.toUpperCase()+"%'");
			}
			
			ResultSet rs = handler.executeSelectStatement(mainQuery, con);

			LIST_DATATABLE.clear();
			while(rs.next()) {
				PM_IL_COVER bean  = new PM_IL_COVER();
					bean.setROWID(rs.getString("ROWID"));
					bean.setCOVER_CODE(rs.getString("COVER_CODE"));
					bean.setCOVER_DESC(rs.getString("COVER_DESC"));
					bean.setCOVER_FRZ_FLAG("COVER_FRZ_FLAG");
				LIST_DATATABLE.add(bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String openForm() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		sessionMap.put("CURRENT_MODE", "QUERY");
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		CRUDHandler handler = new CRUDHandler();
		ELResolver resolver = context.getELContext().getELResolver();
		//PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_COVER_ACTION"); 

		PM_IL_COVER_ACTION coverAction = new PM_IL_COVER_ACTION();
		session.setAttribute("PILM203_PM_IL_COVER_ACTION", coverAction);
		try {
			Connection con = CommonUtils.getConnection();
			Object rowData = getCOMP_DATATABLE().getRowData();
			//PILM203_SEARCH_VALUE_BEAN valueBean = (PILM203_SEARCH_VALUE_BEAN)rowData ;
			PM_IL_COVER pm_il_cover = (PM_IL_COVER)rowData;
			coverAction.getPM_IL_COVER_BEAN().setCOVER_CODE(pm_il_cover.getCOVER_CODE());
			System.out.println("ROW id:::::"+pm_il_cover.getCOVER_CODE());
			/*String coverCode = valueBean.getCOVER_CODE();
			String cover_desc = valueBean.getCOVER_LONG_DESC();*/
			//String rowId = valueBean.getROWID();
			String queryForPM_IL_COVER = PM_IL_MED_COVER_CONSTANTS.PM_IL_MED_COVER_SEARCH_QUERY;
			System.out.println(queryForPM_IL_COVER);

			new PM_IL_COVER_DELEGATE().setExistingValues(coverAction.getPM_IL_COVER_BEAN());
			/*List<PM_IL_COVER> list = handler.fetch(queryForPM_IL_COVER, "com.iii.pel.forms.PILM203.PM_IL_COVER", con);
			if(list != null && list.size() > 0) {
				PM_IL_COVER coverBean = (PM_IL_COVER)list.get(0);
				System.out.println(coverBean.getCOVER_LIMIT_TYPE()+" "+coverBean.getCOVER_LC_LIMIT()
						+"  "+coverBean.getCOVER_LIMIT_DAYS()+"  "+coverBean.getCOVER_PER_DAY_LC_AMT());
				coverAction.setPM_IL_COVER_BEAN(coverBean);
			}*/
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "nextpage";
	}


	public PILM203_SEARCH_VALUE_BEAN getSearchValueBean() {
		return searchValueBean;
	}

	public void setSearchValueBean(PILM203_SEARCH_VALUE_BEAN searchValueBean) {
		this.searchValueBean = searchValueBean;
	}
	
	public void deleteRow(PILM203_SEARCH_VALUE_BEAN bean) {
		
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		ResultSet rs = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		String cover_code = bean.getCOVER_CODE();
		String rowId = bean.getROWID();
		
		String selectCOVER = "select CBL_BNF_CODE from PM_IL_CVR_BNF_LINK where CBL_COVER_CODE = '"+cover_code+"'";
		String cbl_bnf_code = null;
		try {
			rs = handler.executeSelectStatement(selectCOVER, con);
			if(rs.next()) {
				cbl_bnf_code = rs.getString("CBL_BNF_CODE");
				System.out.println("PILM203_SEARCH_ACTION_BEAN.deleteRow() bnf_code "+cbl_bnf_code);
			}


			String queryForMainBlock = "delete from PM_IL_COVER where ROWID = '"+rowId+"'";
			String queryForCVR_BNF = "delete from PM_IL_CVR_BNF_LINK where CBL_COVER_CODE = '"+cover_code+"'";
			String queryForCVR_SBNF = "delete from PM_IL_CVR_SBNF_LINK where " +
			"BSBL_COVER_CODE = '"+cover_code+"' and BSBL_BNF_CODE = '"+cbl_bnf_code+"'";
			String queryForBNF_DEDB_LINK = "delete from PM_IL_BNF_DEDB_LINK where " +
			"BDL_COVER_CODE = '"+cover_code+"' and BDL_BNF_CODE = '"+cbl_bnf_code+"'";
			String queryForAGE_SETUP = "delete from PM_IL_BNF_AGE_SETUP where " +
			"BAS_COVER_CODE = '"+cover_code+"' and BAS_BNF_CODE = '"+cbl_bnf_code+"'";

			System.out.println("PILM203_SEARCH_ACTION_BEAN.deleteRow() queries "+queryForMainBlock+" "
					+queryForCVR_SBNF+"  "+queryForCVR_BNF+"  "+queryForBNF_DEDB_LINK+"  "+queryForAGE_SETUP);

			handler.executeDeleteStatement(queryForMainBlock, con);
			handler.executeDeleteStatement(queryForCVR_BNF, con);
			handler.executeDeleteStatement(queryForCVR_SBNF, con);
			handler.executeDeleteStatement(queryForBNF_DEDB_LINK, con);
			handler.executeDeleteStatement(queryForAGE_SETUP, con);
			try {
				con.commit();
				System.out.println("PILM203_SEARCH_ACTION_BEAN.deleteRow() row deleted from all blocks");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public HtmlAjaxCommandButton getINSERT_BUTTON() {
		return INSERT_BUTTON;
	}

	public void setINSERT_BUTTON(HtmlAjaxCommandButton insert_button) {
		INSERT_BUTTON = insert_button;
	}
	
	public String updateButtonAction(String rowId) {
		PM_IL_COVER_ACTION coverAction = new PM_IL_COVER_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PILM203_PM_IL_COVER_ACTION",
				coverAction);
		coverAction.getPM_IL_COVER_BEAN().setROWID(rowId);
	
		outcome = "nextpage";
		return outcome;
    }

    public String insertButtonAction() {
    	PM_IL_COVER_ACTION coverAction = new PM_IL_COVER_ACTION();
    	String outcome = null;
	
		CommonUtils.setGlobalObject("PILM203_PM_IL_COVER_ACTION",
				coverAction);
		outcome = "nextpage";

		return outcome;
	
    }
	
    public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
    }

	
}
