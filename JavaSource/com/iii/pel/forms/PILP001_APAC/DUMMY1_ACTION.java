package com.iii.pel.forms.PILP001_APAC;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY1_ACTION {
	
	private Connection connection = null;
	
	Map session = null;
	
	private ControlBean controlBean  = null;

	private HtmlOutputLabel COMP_UI_M_GEN_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_GEN_POL_NO;

	private HtmlCommandButton COMP_UI_M_BUT_POL_OK;

	private HtmlCommandButton COMP_UI_M_BUT_POL_CANCEL;

	private DUMMY1 DUMMY1_BEAN;

	public DUMMY1_ACTION() {
		DUMMY1_BEAN = new DUMMY1();
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
	}

	public HtmlOutputLabel getCOMP_UI_M_GEN_POL_NO_LABEL() {
		return COMP_UI_M_GEN_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_GEN_POL_NO() {
		return COMP_UI_M_GEN_POL_NO;
	}

	public void setCOMP_UI_M_GEN_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_GEN_POL_NO_LABEL) {
		this.COMP_UI_M_GEN_POL_NO_LABEL = COMP_UI_M_GEN_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_GEN_POL_NO(HtmlInputText COMP_UI_M_GEN_POL_NO) {
		this.COMP_UI_M_GEN_POL_NO = COMP_UI_M_GEN_POL_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_OK() {
		return COMP_UI_M_BUT_POL_OK;
	}

	public void setCOMP_UI_M_BUT_POL_OK(HtmlCommandButton COMP_UI_M_BUT_POL_OK) {
		this.COMP_UI_M_BUT_POL_OK = COMP_UI_M_BUT_POL_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_CANCEL() {
		return COMP_UI_M_BUT_POL_CANCEL;
	}

	public void setCOMP_UI_M_BUT_POL_CANCEL(HtmlCommandButton COMP_UI_M_BUT_POL_CANCEL) {
		this.COMP_UI_M_BUT_POL_CANCEL = COMP_UI_M_BUT_POL_CANCEL;
	}

	public DUMMY1 getDUMMY1_BEAN() {
		return DUMMY1_BEAN;
	}

	public void setDUMMY1_BEAN(DUMMY1 DUMMY1_BEAN) {
		this.DUMMY1_BEAN = DUMMY1_BEAN;
	}
	
	public void pilp001_apac_dummy_m_but_pol_ok_when_button_pressed() throws SQLException,Exception    {
		
		connection = CommonUtils.getConnection();
        try
        {
            //final dbms_output dbms_output1=new dbms_output();
            //L_VALIDATE_POLICY_NO.L_VALIDATE_POLICY_NO();
            getControlBean().setM_COMM_DEL("C");
            if(!connection.getAutoCommit())
            connection.commit();
            getControlBean().setM_COMM_DEL(null);
            if(DUMMY1_BEAN.getUI_M_GEN_POL_NO()!= null)
            {
                System.out
						.println("DUMMY1_ACTION.pilp001_apac_dummy_m_but_pol_ok_when_button_pressed()");
            	//STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71058,:CTRL.M_LANG_CODE,:DUMMY.M_PROP_NO);
                /*if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)=="PILT002_APAC")
                {
                    EXIT_FORM.EXIT_FORM(NO_VALIDATE);
                }
                else
                {
                    GO_ITEM.GO_ITEM("DUMMY.M_PROP_NO");
                    CLEAR_BLOCK.CLEAR_BLOCK();
                }*/
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
		
    }
	
	
	public void pilp001_apac_dummy_m_but_pol_cancel_when_button_pressed() throws SQLException,Exception
    {
        connection = CommonUtils.getConnection();
        try
        {
            //final dbms_output dbms_output1=new dbms_output();
            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_GEN_POL_NO",REQUIRED,PROPERTY_FALSE);
            //HIDE_WINDOW("DUMMY1");
            //GO_ITEM.GO_ITEM("DUMMY.M_PROP_NO");
            //SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_GEN_POL_NO",ENABLED,PROPERTY_FALSE);
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        
    }

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}
	
	/*public Connection getConnection() throws Exception{
		FacesContext fc = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext)fc.getExternalContext().getContext();
		SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context.getAttribute("connectionAgent");
		return connectionAgent.getConnection("System.currentTimeMillis()");
	}*/
	
	
	
}
