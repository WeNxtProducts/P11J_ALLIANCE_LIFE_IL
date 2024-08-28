package com.iii.pel.forms.PT048_A;

public class Rank {
	private String code;
	private String 	Desc;
	/* [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV values*/
	public Rank()
	{
		
	}
	/* [ BugId:PREMIAGDC-AGENCY-0028 Deepika 04-Feb-09 Populating LOV values*/
	public Rank(String string, String string2) {
		this.code=string;
		this.Desc=string2;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}	
}
