package com.iii.pel.forms.PILM106;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.apps.persistence.Id;

/*@Table(name="PP_LIST_ITEM_VALUES")*/
public class PILM106_EMAIL_LIST extends BaseValueBean {
	/* @Id 	*/
private String EMAIL_KEY;
private String EMAIL_LABEL;
public String getEMAIL_KEY() {
	return EMAIL_KEY;
}
public void setEMAIL_KEY(String eMAIL_KEY) {
	EMAIL_KEY = eMAIL_KEY;
}
public String getEMAIL_LABEL() {
	return EMAIL_LABEL;
}
public void setEMAIL_LABEL(String eMAIL_LABEL) {
	EMAIL_LABEL = eMAIL_LABEL;
}


}
