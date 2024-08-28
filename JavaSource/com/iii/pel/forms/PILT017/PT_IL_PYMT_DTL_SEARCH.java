package com.iii.pel.forms.PILT017;


public class PT_IL_PYMT_DTL_SEARCH {
	
	/*private ArrayList fetchDtlList;
	private String  payMode;
	private String storedPayMode;
	private ArrayList<PT_IL_PYMT_DTLS> dataTableList;
	private PT_IL_PYMT_DTLS_DB_CLASS dbHelper;
	private PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN;
	
	List resultList;

	
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getStoredPayMode() {
		return storedPayMode;
	}
	public void setStoredPayMode(String storedPayMode) {
		this.storedPayMode = storedPayMode;
	}
	
	public String fetchList(){
		
		PT_IL_PYMT_DTLS_DB_CLASS dbClass = new PT_IL_PYMT_DTLS_DB_CLASS();
		this.fetchDtlList = dbClass.fetchList(this);
		System.out.println("In fetch List " );
		return null;
		
	}
	
	public String searchResult(){
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		PT_IL_PYMT_DTLS_ACTION pymtDtlAction= new PT_IL_PYMT_DTLS_ACTION();
		session.setAttribute("PT_IL_PYMT_DTLS_ACTION",pymtDtlAction);
		String sysId = request.getParameter("sysId");
		PT_IL_PYMT_DTLS_DB_CLASS dbHelper = new PT_IL_PYMT_DTLS_DB_CLASS();
		dbHelper.fetchPaymentDtls(sysId, pymtDtlAction.getPT_IL_PYMT_DTLS_BEAN());
		//dbHelper.fetchValues(sysId);
	 	this.fetchDtlList=null;
	 	
	 	fetchDtlList=(ArrayList) dbHelper.fetchPaymentDtls(sysId, pymtDtlAction.getPT_IL_PYMT_DTLS_BEAN());
		String returnStr = "goToPymtDtls";
		System.out.println(" In searchResult");
		return returnStr;
	}
	
	public String searchResult(){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		
		PT_IL_PYMT_DTLS_ACTION pymtDtlAction= new PT_IL_PYMT_DTLS_ACTION();
		session.setAttribute("PT_IL_PYMT_DTLS_ACTION",pymtDtlAction);
		String sysId = request.getParameter("sysId");
		this.fetchDtlList=null;
		
		dataTableList = new ArrayList<PT_IL_PYMT_DTLS>();
		dbHelper = new PT_IL_PYMT_DTLS_DB_CLASS();
		resultList=new ArrayList();
		try {
			resultList=dbHelper.fetchValues(sysId);
			for(int index=0; index<resultList.size(); index++ )
			{
				PT_IL_PYMT_DTLS pymtDtl = (PT_IL_PYMT_DTLS) resultList.get(index);
				dataTableList.add(pymtDtl);
			}
			PT_IL_PYMT_DTLS pymtDtl = (PT_IL_PYMT_DTLS) resultList.get(0);
			dataTableList.add(pymtDtl);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
		
		
		dataTableList.add(new PT_IL_PYMT_DTLS());
		dataTableList.add(new PT_IL_PYMT_DTLS());
		
		String returnStr = "goToPymtDtls";
		System.out.println(" In searchResult");
		return returnStr;

	}

	public ArrayList getFetchDtlList() {
		return fetchDtlList;
	}
	public void setFetchDtlList(ArrayList fetchDtlList) {
		this.fetchDtlList = fetchDtlList;
	}
	public ArrayList<PT_IL_PYMT_DTLS> getDataTableList() {
		return dataTableList;
	}
	public void setDataTableList(ArrayList<PT_IL_PYMT_DTLS> dataTableList) {
		this.dataTableList = dataTableList;
	}
*/
}
