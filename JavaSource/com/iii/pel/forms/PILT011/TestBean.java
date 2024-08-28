package com.iii.pel.forms.PILT011;

import java.util.Map;

import javax.faces.context.FacesContext;


public class TestBean {
	
private String POL_SYS_ID; 
private String CLM_SYS_ID; 
private String COVER_CODE; 
private String FAC_RI_BUT="R";

public String getPOL_SYS_ID() {
	return POL_SYS_ID;
}
public void setPOL_SYS_ID(String pol_sys_id) {
	POL_SYS_ID = pol_sys_id;
}
public String getCLM_SYS_ID() {
	return CLM_SYS_ID;
}
public void setCLM_SYS_ID(String clm_sys_id) {
	CLM_SYS_ID = clm_sys_id;
}
public String getCOVER_CODE() {
	return COVER_CODE;
}
public void setCOVER_CODE(String cover_code) {
	COVER_CODE = cover_code;
}
public String getFAC_RI_BUT() {
	return FAC_RI_BUT;
}
public void setFAC_RI_BUT(String fac_ri_but) {
	FAC_RI_BUT = fac_ri_but;
}

public String FACDetails(){
	
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	session.put("SYSTEM.FORM_STATUS","QUERY");
	session.put("GLOBAL.POL_SYS_ID", getPOL_SYS_ID());
	session.put("GLOBAL.CLM_SYS_ID", getCLM_SYS_ID());
	session.put("GLOBAL.COVER_CODE", getCOVER_CODE());
	session.put("GLOBAL.FAC_RI_BUT", "F");
	session.put("GLOBAL.CALLING_FORM","PILT006_APAC");
	return "FACDetailsPage";
}
public String RIDetails(){
	
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	
	session.put("SYSTEM.FORM_STATUS","QUERY");
	session.put("GLOBAL.POL_SYS_ID", getPOL_SYS_ID());
	session.put("GLOBAL.CLM_SYS_ID", getCLM_SYS_ID());
	session.put("GLOBAL.COVER_CODE", getCOVER_CODE());
	session.put("GLOBAL.FAC_RI_BUT", "R");
	session.put("GLOBAL.CALLING_FORM","PILT006_APAC");
	return "RIDetailsPage";
}

}
//RI DETAILS
/*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
RAISE FORM_TRIGGER_FAILURE;
END IF;
:GLOBAL.POL_SYS_ID := :PT_IL_CLAIM.CLAIM_POL_SYS_ID ;
:GLOBAL.CLM_SYS_ID := :PT_IL_CLAIM.CLAIM_SYS_ID;
:GLOBAL.COVER_CODE := :PT_IL_CLAIM_COVER_DTLS.CCD_COVER_CODE;
:GLOBAL.FAC_RI_BUT := 'R';
CALL_FORM('PILT011', NO_HIDE, NO_REPLACE, QUERY_ONLY);
*/

//FAC DETAILS
/*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
STD_MESSAGE_ROUTINE(71048,:GLOBAL.M_LANG_CODE);
RAISE FORM_TRIGGER_FAILURE;
END IF;
:GLOBAL.POL_SYS_ID := :PT_IL_CLAIM.CLAIM_POL_SYS_ID ;
:GLOBAL.CLM_SYS_ID := :PT_IL_CLAIM.CLAIM_SYS_ID;
:GLOBAL.COVER_CODE := :PT_IL_CLAIM_COVER_DTLS.CCD_COVER_CODE;
:GLOBAL.FAC_RI_BUT := 'F';
CALL_FORM('PILT011', NO_HIDE, NO_REPLACE, QUERY_ONLY);
*/
