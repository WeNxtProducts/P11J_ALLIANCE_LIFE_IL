package com.iii.pel.forms.PILM039;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.pel.commonimpl.treewizardimpl.wizard.UIWizard;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPR_SETUP_COMPOSITE_ACTION {
	private PM_IL_APPR_DEPT_SETUP_ACTION PM_IL_APPR_DEPT_SETUP_ACTION_BEAN;
	private PM_IL_APPR_SETUP_ACTION PM_IL_APPR_SETUP_ACTION_BEAN;
	private PM_IL_APPR_SETUP_DET1_ACTION PM_IL_APPR_SETUP_DET1_ACTION_BEAN;
	private PM_IL_END_APPR_SETUP_ACTION PM_IL_END_APPR_SETUP_ACTION_BEAN;
	private PM_IL_APPR_SETUP_DET_ACTION PM_IL_APPR_SETUP_DET_ACTION_BEAN;
	private PM_IL_APPR_SETUP_SEARCH_ACTION PM_IL_APPR_SETUP_SEARCH_ACTION_BEAN;
	private ControlBean controlBean;
	private UIWizard wizard=null;
	PILM039_DELIGATE delegate = new PILM039_DELIGATE();
	//private TabbedBar tabbedBar =null;
	public static final int				HEADER				= 1;
	public static final int				DIVISIONS			= 2;
	public static final int				RIGHTS				= 3;
	public static final int				LIMITS				= 4;
	public static final int				PROCESS_APPROVAL	= 5;

	public PM_IL_APPR_SETUP_COMPOSITE_ACTION() {
		
		PM_IL_APPR_DEPT_SETUP_ACTION_BEAN = new PM_IL_APPR_DEPT_SETUP_ACTION();
		PM_IL_APPR_SETUP_ACTION_BEAN = new PM_IL_APPR_SETUP_ACTION();
		PM_IL_APPR_SETUP_DET1_ACTION_BEAN = new PM_IL_APPR_SETUP_DET1_ACTION();
		PM_IL_END_APPR_SETUP_ACTION_BEAN = new PM_IL_END_APPR_SETUP_ACTION();
		PM_IL_APPR_SETUP_DET_ACTION_BEAN = new PM_IL_APPR_SETUP_DET_ACTION();
		PM_IL_APPR_SETUP_SEARCH_ACTION_BEAN = new PM_IL_APPR_SETUP_SEARCH_ACTION();
		controlBean=(ControlBean)CommonUtils.getControlBean().clone();
		
		PM_IL_APPR_DEPT_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_END_APPR_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_APPR_SETUP_ACTION_BEAN.compositeAction = this;
		PM_IL_APPR_SETUP_DET1_ACTION_BEAN.compositeAction = this;
		PM_IL_APPR_SETUP_DET_ACTION_BEAN.compositeAction = this;
		
		//loadingBaseValues();
		//tabbedBar = new TabbedBar();
		
		try {
			/*tabbedBar.addTab(HEADER,"#{PM_IL_APPR_SETUP_COMPOSITE_ACTION.headerAction}","Header",false);
			tabbedBar.addTab(DIVISIONS,"#{PM_IL_APPR_SETUP_COMPOSITE_ACTION.divisionAction}", "Divisions", false);
			tabbedBar.addTab(RIGHTS,"#{PM_IL_APPR_SETUP_COMPOSITE_ACTION.rightsAction}", "Rights", false);
			tabbedBar.addTab(LIMITS,"#{PM_IL_APPR_SETUP_COMPOSITE_ACTION.limitsAction}","Limits",false);*/
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00195: Hide Process/Approval tab . Added by : Shankar B, 04-Apr-2009 
			//tabbedBar.addTab(PROCESS_APPROVAL,"#{PM_IL_APPR_SETUP_COMPOSITE_ACTION.processAction}", "Process/Approval", false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void resetAllValues(){
		PM_IL_APPR_DEPT_SETUP_ACTION_BEAN = new PM_IL_APPR_DEPT_SETUP_ACTION();
		PM_IL_APPR_SETUP_ACTION_BEAN = new PM_IL_APPR_SETUP_ACTION();
		PM_IL_APPR_SETUP_DET1_ACTION_BEAN = new PM_IL_APPR_SETUP_DET1_ACTION();
		PM_IL_END_APPR_SETUP_ACTION_BEAN = new PM_IL_END_APPR_SETUP_ACTION();
		PM_IL_APPR_SETUP_DET_ACTION_BEAN = new PM_IL_APPR_SETUP_DET_ACTION();
	}
	
	public String headerAction(){
		String outCome=null;
		try {
			saveCurrentTab();
			outCome="PILM039_PM_IL_APPR_SETUP";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	}
	public String divisionAction(){
		String outCome=null;
		try {
			saveCurrentTab();
			ArrayList<PM_IL_APPR_DEPT_SETUP> dataList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			PM_IL_APPR_DEPT_SETUP_ACTION listAction = null;

			PM_IL_APPR_SETUP_ACTION action=this.getPM_IL_APPR_SETUP_ACTION_BEAN();
			dataList = deligate.loadDeptAndBranchValues(action);
			listAction = this.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN();

			if (listAction == null) {
				listAction = new PM_IL_APPR_DEPT_SETUP_ACTION();
				this.setPM_IL_APPR_DEPT_SETUP_ACTION_BEAN(listAction);
			}
			//For Default Select
			for(int i =0;i<dataList.size();i++){
				PM_IL_APPR_DEPT_SETUP pmDeptSet = (PM_IL_APPR_DEPT_SETUP)dataList.get(i);
				if(i==0){
					pmDeptSet.setRowSelected(true);
					listAction.setPM_IL_APPR_DEPT_SETUP_BEAN(pmDeptSet);
				}else{
					pmDeptSet.setRowSelected(false);
				}
			}
			
			listAction.setList(dataList);
			if(dataList.size() > 0){
				
				CommonUtils.objectSysout((PM_IL_APPR_DEPT_SETUP)dataList.get(0));
			}
			
			outCome="division";

		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
		
	}
	
	public String rightsAction(){
		String outCome=null;
		try {
			saveCurrentTab();
			ArrayList<PM_IL_APPR_SETUP_DET> dataList = new ArrayList<PM_IL_APPR_SETUP_DET>();
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			PILM039_HELPER helper = new PILM039_HELPER();
			PM_IL_APPR_SETUP_DET_ACTION listAction = null;
			boolean isRecordCheck = false;
			
			PM_IL_APPR_SETUP_ACTION action=this.getPM_IL_APPR_SETUP_ACTION_BEAN();
			PM_IL_APPR_SETUP valueBean = action.getPM_IL_APPR_SETUP_BEAN(); 
			String P_USER_ID = valueBean.getAS_USER_ID();
			String P_PROD_FM = valueBean.getAS_FM_PROD_CODE();
			String P_PROD_TO = valueBean.getAS_TO_PROD_CODE();
			// PREMIAGDC-0135 – FETCHING  ASD_APPR_GRP VALUE FROM SESSION, Added by: Shankar Bodduluri, Dated: 13-Mar-2009
			
			String ASD_APPR_GRP = this.getPM_IL_APPR_SETUP_DET_ACTION_BEAN().getPM_IL_APPR_SETUP_DET_BEAN().getASD_APPR_GRP();
			/*isRecordCheck = helper.checkDuplicateRecord(action.getPM_IL_APPR_SETUP_BEAN());
			if(!isRecordCheck){
				helper.PRE_INSERT(P_USER_ID, P_PROD_FM, P_PROD_TO);
			}*///commented by Varun(50663)
				dataList = deligate.loadRightsValues(action,ASD_APPR_GRP);
			listAction = this.getPM_IL_APPR_SETUP_DET_ACTION_BEAN();
			if (listAction == null) {
				listAction = new PM_IL_APPR_SETUP_DET_ACTION();
				this.setPM_IL_APPR_SETUP_DET_ACTION_BEAN(listAction);
			}
			//Data list default value set.
			for(int i=0;i<dataList.size();i++){
				PM_IL_APPR_SETUP_DET pmSetUpDt = dataList.get(i);
				if(i==0){
					pmSetUpDt.setRowSelected(true);
					listAction.setPM_IL_APPR_SETUP_DET_BEAN(pmSetUpDt);
				}else{
					pmSetUpDt.setRowSelected(false);
				}
			}
			
			
			listAction.setList(dataList);
			
			outCome="rights";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;

	}
	public String limitsAction(){
		String outCome=null;
		try {
			saveCurrentTab();
			ArrayList<PM_IL_APPR_SETUP_DET1> dataList = new ArrayList<PM_IL_APPR_SETUP_DET1>();
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			CommonUtils commonUtils =new CommonUtils();
			PM_IL_APPR_SETUP_DET1_ACTION listAction = null;
			PILM039_HELPER helper = new PILM039_HELPER();
			PM_IL_APPR_SETUP_ACTION action=this.getPM_IL_APPR_SETUP_ACTION_BEAN();
			
			boolean isRecordCheck = false;
			PM_IL_APPR_SETUP valueBean = action.getPM_IL_APPR_SETUP_BEAN();
			String P_USER_ID = valueBean.getAS_USER_ID();
			String P_PROD_FM = valueBean.getAS_FM_PROD_CODE();
			String P_PROD_TO = valueBean.getAS_TO_PROD_CODE();
			
			/*	isRecordCheck = helper.checkDuplicateRecord(action.getPM_IL_APPR_SETUP_BEAN());
		if(!isRecordCheck){
			helper.PRE_INSERT(P_USER_ID, P_PROD_FM, P_PROD_TO);
		}*///commented by Varun(50663)
					// PREMIAGDC-0135 – FETCHING  ASD_APPR_GRP VALUE FROM SESSION, Added by: Shankar Bodduluri, Dated: 13-Mar-2009
			String ASD_APPR_GRP = this.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN().getPM_IL_APPR_SETUP_DET1_BEAN().getASD_APPR_GRP();
			dataList = deligate.loadLimitsValues(action,ASD_APPR_GRP);
			listAction = this.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN();
			if (listAction == null) {
				listAction = new PM_IL_APPR_SETUP_DET1_ACTION();
				this.setPM_IL_APPR_SETUP_DET1_ACTION_BEAN(listAction);
			}
			//Data list default value set.
			for(int i=0;i<dataList.size();i++){
				PM_IL_APPR_SETUP_DET1 pmSetUpDt = dataList.get(i);
				if(i==0){
					pmSetUpDt.setRowSelected(true);
					listAction.setPM_IL_APPR_SETUP_DET1_BEAN(pmSetUpDt);
				}else{
					pmSetUpDt.setRowSelected(false);
				}
			}
			listAction.setList(dataList);
			outCome="limits";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;

	}
	
	public String processAction(){
		
		//Code shifted to action class
//		ArrayList<PM_IL_END_APPR_SETUP> dataList = new ArrayList<PM_IL_END_APPR_SETUP>();
//		PILM039_DELIGATE deligate = new PILM039_DELIGATE();
//		CommonUtils commonUtils =new CommonUtils();
//		PM_IL_END_APPR_SETUP_ACTION listAction = null;
//
//		PM_IL_APPR_SETUP_ACTION action=this.getPM_IL_APPR_SETUP_ACTION_BEAN();
//		dataList = deligate.loadProcessEndosmentValues(action);
//
//		listAction = this.getPM_IL_END_APPR_SETUP_ACTION_BEAN();
//		if (listAction == null) {
//			listAction = new PM_IL_END_APPR_SETUP_ACTION();
//			this.setPM_IL_END_APPR_SETUP_ACTION_BEAN(listAction);
//		}
//		listAction.setList(dataList);
		String outCome=null;
		try {
			saveCurrentTab();
			//PM_IL_END_APPR_SETUP_ACTION_BEAN.preBlockPM_IL_END_APPR_SETUP();
			
			PM_IL_END_APPR_SETUP_ACTION_BEAN.setBlockFlag(true);
			PM_IL_END_APPR_SETUP_ACTION_BEAN.setPM_IL_END_APPR_SETUP_BEAN(
					(PM_IL_END_APPR_SETUP_ACTION_BEAN.populateBlockPM_IL_END_APPR_SETUP()));
			PM_IL_END_APPR_SETUP_ACTION_BEAN.postQueryPM_IL_END_APPR_SETUP();
			outCome="process";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outCome;
	}
	

	/*public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}
*/
		/**
	 * @return the pM_IL_APPR_DEPT_SETUP_ACTION_BEAN
	 */
	public PM_IL_APPR_DEPT_SETUP_ACTION getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN() {
		return PM_IL_APPR_DEPT_SETUP_ACTION_BEAN;
	}


	/**
	 * @param pm_il_appr_dept_setup_action_bean the pM_IL_APPR_DEPT_SETUP_ACTION_BEAN to set
	 */
	public void setPM_IL_APPR_DEPT_SETUP_ACTION_BEAN(
			PM_IL_APPR_DEPT_SETUP_ACTION pm_il_appr_dept_setup_action_bean) {
		PM_IL_APPR_DEPT_SETUP_ACTION_BEAN = pm_il_appr_dept_setup_action_bean;
	}


	/**
	 * @return the pM_IL_APPR_SETUP_ACTION_BEAN
	 */
	public PM_IL_APPR_SETUP_ACTION getPM_IL_APPR_SETUP_ACTION_BEAN() {
		return PM_IL_APPR_SETUP_ACTION_BEAN;
	}


	/**
	 * @param pm_il_appr_setup_action_bean the pM_IL_APPR_SETUP_ACTION_BEAN to set
	 */
	public void setPM_IL_APPR_SETUP_ACTION_BEAN(
			PM_IL_APPR_SETUP_ACTION pm_il_appr_setup_action_bean) {
		PM_IL_APPR_SETUP_ACTION_BEAN = pm_il_appr_setup_action_bean;
	}


	/**
	 * @return the pM_IL_APPR_SETUP_DET1_ACTION_BEAN
	 */
	public PM_IL_APPR_SETUP_DET1_ACTION getPM_IL_APPR_SETUP_DET1_ACTION_BEAN() {
		return PM_IL_APPR_SETUP_DET1_ACTION_BEAN;
	}


	/**
	 * @param pm_il_appr_setup_det1_action_bean the pM_IL_APPR_SETUP_DET1_ACTION_BEAN to set
	 */
	public void setPM_IL_APPR_SETUP_DET1_ACTION_BEAN(
			PM_IL_APPR_SETUP_DET1_ACTION pm_il_appr_setup_det1_action_bean) {
		PM_IL_APPR_SETUP_DET1_ACTION_BEAN = pm_il_appr_setup_det1_action_bean;
	}


	/**
	 * @return the pM_IL_END_APPR_SETUP_ACTION_BEAN
	 */
	public PM_IL_END_APPR_SETUP_ACTION getPM_IL_END_APPR_SETUP_ACTION_BEAN() {
		return PM_IL_END_APPR_SETUP_ACTION_BEAN;
	}


	/**
	 * @param pm_il_end_appr_setup_action_bean the pM_IL_END_APPR_SETUP_ACTION_BEAN to set
	 */
	public void setPM_IL_END_APPR_SETUP_ACTION_BEAN(
			PM_IL_END_APPR_SETUP_ACTION pm_il_end_appr_setup_action_bean) {
		PM_IL_END_APPR_SETUP_ACTION_BEAN = pm_il_end_appr_setup_action_bean;
	}


	/**
	 * @return the pM_IL_APPR_SETUP_DET_ACTION_BEAN
	 */
	public PM_IL_APPR_SETUP_DET_ACTION getPM_IL_APPR_SETUP_DET_ACTION_BEAN() {
		return PM_IL_APPR_SETUP_DET_ACTION_BEAN;
	}


	/**
	 * @param pm_il_appr_setup_det_action_bean the pM_IL_APPR_SETUP_DET_ACTION_BEAN to set
	 */
	public void setPM_IL_APPR_SETUP_DET_ACTION_BEAN(
			PM_IL_APPR_SETUP_DET_ACTION pm_il_appr_setup_det_action_bean) {
		PM_IL_APPR_SETUP_DET_ACTION_BEAN = pm_il_appr_setup_det_action_bean;
	}


	/**
	 * @return the pM_IL_APPR_SETUP_SEARCH_ACTION_BEAN
	 */
	public PM_IL_APPR_SETUP_SEARCH_ACTION getPM_IL_APPR_SETUP_SEARCH_ACTION_BEAN() {
		return PM_IL_APPR_SETUP_SEARCH_ACTION_BEAN;
	}


	/**
	 * @param pm_il_appr_setup_search_action_bean the pM_IL_APPR_SETUP_SEARCH_ACTION_BEAN to set
	 */
	public void setPM_IL_APPR_SETUP_SEARCH_ACTION_BEAN(
			PM_IL_APPR_SETUP_SEARCH_ACTION pm_il_appr_setup_search_action_bean) {
		PM_IL_APPR_SETUP_SEARCH_ACTION_BEAN = pm_il_appr_setup_search_action_bean;
	}


	/**
	 * @return the delegate
	 */
	public PILM039_DELIGATE getDelegate() {
		return delegate;
	}


	/**
	 * @param delegate the delegate to set
	 */
	public void setDelegate(PILM039_DELIGATE delegate) {
		this.delegate = delegate;
	}

	 public void loadingBaseValues() 
     {
 		FacesContext fc = FacesContext.getCurrentInstance();
 	    System.out.println("ENTERE PHASE EVENT");
 	    
 		Map<String, Object> session = fc.getExternalContext().getSessionMap();
 		if(session.get("PM_IL_CONTRACTOR_ACTION_FORM") == null) {
 			try {
 				System.out.println("BEFORE PHASE EVENT");
 				STD_PRE_FORM();
				System.out.println("AFTER PHASE EVENT");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
 			session.put("PM_IL_CONTRACTOR_ACTION_FORM","true");
 		} 
 	}
	 
		private void STD_PRE_FORM() {
			FacesContext facesContext =FacesContext.getCurrentInstance();
			ControlBean controlBean =new ControlBean();
			Map<String, Object> session=facesContext.getExternalContext().getSessionMap();
			System.out.println("PM_IL_APPR_SETUP_ACTION.STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
			controlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
			controlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
			controlBean.setM_PROG_NAME("PILM039");
			System.out.println("PM_IL_APPR_SETUP_ACTION.STD_PRE_FORM(------)" +(String)session.get("GLOBAL.M_NAME"));
			controlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30, 42));
			session.put("GLOBAL.M_FAILURE", "FALSE");
			controlBean.setM_GOFLD_NAME("NULL");
			controlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
			controlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
			controlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
			System.out.println("PM_IL_APPR_SETUP_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
			controlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));
			System.out.println("PM_IL_APPR_SETUP_ACTION.STD_PRE_FORM()--- \n "+controlBean.getM_LANG_CODE()+"\t"+controlBean.getM_COMP_CODE()+"\t"+controlBean.getM_PARA_1());
			
			session.put("controlBean", controlBean);
		}
		
		public void callRightPage()
		{
			ArrayList<PM_IL_APPR_SETUP_DET> dataList = new ArrayList<PM_IL_APPR_SETUP_DET>();
			CommonUtils commonUtils =new CommonUtils();
			PILM039_DELIGATE deligate =new PILM039_DELIGATE();
			PM_IL_APPR_SETUP_DET_ACTION listAction = null;
			PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction=null;
			
			compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
				// PREMIAGDC-0135 –  for ASD_APPR_GRP , Added by: Shankar Bodduluri, Dated: 13-Mar-2009
			String ASD_APPR_GRP = compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN().getPM_IL_APPR_SETUP_DET_BEAN().getASD_APPR_GRP();
				dataList = deligate.loadRightsValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN(),ASD_APPR_GRP);
			
			
			listAction =compositeAction.getPM_IL_APPR_SETUP_DET_ACTION_BEAN();
			if (listAction == null) {
				listAction = new PM_IL_APPR_SETUP_DET_ACTION();
				compositeAction.setPM_IL_APPR_SETUP_DET_ACTION_BEAN(listAction);
			}
			listAction.setList(dataList);
		}

		public void callLimitsPage() {
			
			ArrayList<PM_IL_APPR_SETUP_DET1> dataList = new ArrayList<PM_IL_APPR_SETUP_DET1>();
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			CommonUtils commonUtils =new CommonUtils();
			PM_IL_APPR_SETUP_DET1_ACTION listAction = null;
			PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction=null;
			
			compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
							// PREMIAGDC-0135 –  for ASD_APPR_GRP , Added by: Shankar Bodduluri, Dated: 13-Mar-2009
			String ASD_APPR_GRP = this.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN().getPM_IL_APPR_SETUP_DET1_BEAN().getASD_APPR_GRP();
			dataList = deligate.loadLimitsValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN(),ASD_APPR_GRP);

			listAction =compositeAction.getPM_IL_APPR_SETUP_DET1_ACTION_BEAN();
			if(listAction == null)
			{
				listAction =new PM_IL_APPR_SETUP_DET1_ACTION();
				compositeAction.setPM_IL_APPR_SETUP_DET1_ACTION_BEAN(listAction);
				System.out.println("lkfjfj"+listAction.getPM_IL_APPR_SETUP_DET1_BEAN().getROWID());
			}
			listAction.setList(dataList);
			
		}

		public void callProcessPage() 
		{
//				ArrayList<PM_IL_END_APPR_SETUP> dataList = new ArrayList<PM_IL_END_APPR_SETUP>();
//				CommonUtils commonUtils =new CommonUtils();
//				PILM039_DELIGATE deligate = new PILM039_DELIGATE();
//				PM_IL_END_APPR_SETUP_ACTION listAction = null;
//				PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
//		
//				compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
//				compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
//				dataList = deligate.loadProcessEndosmentValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN());
//		
//				listAction = compositeAction.getPM_IL_END_APPR_SETUP_ACTION_BEAN();
//				if (listAction == null) {
//					listAction = new PM_IL_END_APPR_SETUP_ACTION();
//					compositeAction.setPM_IL_END_APPR_SETUP_ACTION_BEAN(listAction);
//				}
//				listAction.setList(dataList);
			PM_IL_END_APPR_SETUP_ACTION_BEAN.preBlockPM_IL_END_APPR_SETUP();
			//PM_IL_END_APPR_SETUP_ACTION_BEAN.populateBlockPM_IL_END_APPR_SETUP();
			PM_IL_END_APPR_SETUP_ACTION_BEAN.postQueryPM_IL_END_APPR_SETUP();
		}
		public void calldivisionPage()
		{
			ArrayList<PM_IL_APPR_DEPT_SETUP> dataList = new ArrayList<PM_IL_APPR_DEPT_SETUP>();
			PILM039_DELIGATE deligate = new PILM039_DELIGATE();
			CommonUtils commonUtils =new CommonUtils();
			PM_IL_APPR_DEPT_SETUP_ACTION listAction = null;
			PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = null;
			
			compositeAction = new PM_IL_APPR_SETUP_COMPOSITE_ACTION();
			compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
			dataList = deligate.loadDeptAndBranchValues(compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN());

			listAction =compositeAction.getPM_IL_APPR_DEPT_SETUP_ACTION_BEAN();
			if (listAction == null) {
				listAction =new PM_IL_APPR_DEPT_SETUP_ACTION();
				compositeAction.setPM_IL_APPR_DEPT_SETUP_ACTION_BEAN(listAction);
			}
			listAction.setList(dataList);
		}


		public ControlBean getControlBean() {
			return controlBean;
		}


		public void setControlBean(ControlBean controlBean) {
			this.controlBean = controlBean;
		}
		
		private  void saveCurrentTab() throws Exception{

			//int activeTab = this.tabbedBar.getCurrentTabId();
			/*if(activeTab != 0){
				switch(activeTab){
				case HEADER:
					PM_IL_APPR_SETUP_ACTION_BEAN.validateFormPM_IL_APPR_SET_UP();
					PM_IL_APPR_SETUP_ACTION_BEAN.saveButtonAction(null);

				default:
					System.out.println("-----------> Save not configured for current tabid: "+activeTab);
				}
			}*/
		}


		public UIWizard getWizard() {
			return wizard;
		}


		public void setWizard(UIWizard wizard) {
			wizard = new UIWizard();
			this.wizard = wizard;
		}



}
