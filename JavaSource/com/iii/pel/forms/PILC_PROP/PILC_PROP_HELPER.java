package com.iii.pel.forms.PILC_PROP;

public class PILC_PROP_HELPER {

	public String getPropertyFileName(PILC_PROP_COMPOSITE_ACTION compositeAction) throws Exception
	{
		String propertyFileName = null;
		if(compositeAction.getPILC_PROP_ACTION_BEAN().getPILC_PROP_BEAN().getPILC_MENU_ACTION() != null)
		{
			propertyFileName = "messageProperties_"+compositeAction.getPILC_PROP_ACTION_BEAN().getPILC_PROP_BEAN().getPILC_MENU_ACTION();
		}
		else
		{
			throw new Exception("Menu Action Could not be Empty");
		}
		
		return propertyFileName;
	}
}
