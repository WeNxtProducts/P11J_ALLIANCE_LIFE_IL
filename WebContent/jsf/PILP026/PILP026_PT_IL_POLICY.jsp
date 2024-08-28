<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8"	language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%> 
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<LINK href="${pageContext.request.contextPath }/resources/css/premia_life.css" rel="stylesheet" type="text/css">
<LINK href="${pageContext.request.contextPath }/resources/css/premia_life.css" rel="stylesheet" type="text/css">
<LINK href="${pageContext.request.contextPath }/resources/css/LoginStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
<f:view locale="#{sessionScope['pageLocale']}" beforePhase="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.onLoad}">
<f:loadBundle basename="messageProperties_PILP026" var="message"/>
<f:loadBundle basename="menu" var="menumessage"/>
<table cellpadding="0" cellspacing="0" width="100%" border="0"><tr><td colspan="3"><jsp:include page="../jsp/menu.jsp" /></td></tr><h:form id="PT_IL_POLICY" >
<tr><td colspan="3" width="100%" vAlign="top"><table width="100%" cellpadding="0" cellspacing="0"><tr><td><rich:toolBar styleClass="toolBarStyle" width="100%"><rich:toolBarGroup styleClass="toolBarGroupStyle">
<h:commandLink
    action="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.saveRecord}"
    rendered="true" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\save.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$save}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\savenext.GIF"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$savenext}"/>
</h:commandLink>

<h:commandLink rendered="true" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\deleteRecord.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$deleteRecord}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\firstrec.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$firstrec}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\prevpage.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$prevpage}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\nextpage.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$nextpage}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\lastRecord.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$lastRecord}"/>
</h:commandLink>

<h:commandLink action="#{PILP026_COMPOSITE_ACTION.navigationEnabled}"
    immediate="true" rendered="true" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\navigation.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$undo}"/>
</h:commandLink>
</rich:toolBarGroup></rich:toolBar></td></tr></table></td></tr><tr><td colspan="3" width="100%" vAlign="top" height="20"><table cellspacing="0" width="100%" id="errormsgtable"><tr><td><rich:simpleTogglePanel id="errorPanel" switchType="client" opened="false"><f:facet name="header"><h:outputText id="err" styleClass="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.messageStyle}" value="#{commonmsg.errorPanel$heading}#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.errorMap['current'] !=null? PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.errorMap['current']: PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.warningMap['current']}" /></f:facet><h:outputText id="errorMessages" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.errorMessages}" styleClass="ErrorMessages" escape="false" /><h:messages styleClass="ErrorMessages" id="msg" rendered="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.globalMsgRender}" /><h:outputText id="warningMessages" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.warningMessages}" styleClass="WarningMessages" escape="false" /></rich:simpleTogglePanel></td></tr></table></td></tr>  <tr> <td colspan="3" width="100%" vAlign="top" height="15%">  <table width="100%" cellspacing="0" cellpadding="0" id="globalLink">  <tr><td>  <h:inputHidden value="#{PILP026_COMPOSITE_ACTION.tabbedBar.tabClicked}"   id="myhidden" /> <h:panelGroup id="mypanel" style="border:0;height:15%;"> <table width="100%">   <tr>	<td width="90%"><a4j:repeat value="#{PILP026_COMPOSITE_ACTION.tabbedBar.currentTabList}"    var="currtab"> <h:commandLink	onclick="document.getElementById('PT_IL_POLICY:myhidden').value='#{currtab.id}'"	value="#{currtab.value}" disabled="#{currtab.disabled}"	action="#{PILP026_COMPOSITE_ACTION.tabbedBar.tabAction}"	styleClass="#{currtab.styleString}"  immediate="#{currtab.immediate}"> <f:param name="tabid" value="#{currtab.id}" /></h:commandLink>	</a4j:repeat></td>	<td width="*"><a4j:commandButton immediate="true"	disabled="#{PILP026_COMPOSITE_ACTION.tabbedBar.navigable}"	alt="first" image=".\..\..\images\firstrec.gif"	action="#{PILP026_COMPOSITE_ACTION.tabbedBar.gotoFirstTab}"	reRender="mypanel" /> <a4j:commandButton immediate="true"	disabled="#{PILP026_COMPOSITE_ACTION.tabbedBar.navigable}"	alt="previous" image=".\..\..\images\prevpage.gif"	action="#{PILP026_COMPOSITE_ACTION.tabbedBar.gotoPrevTab}"	reRender="mypanel" /> <a4j:commandButton immediate="true"	disabled="#{PILP026_COMPOSITE_ACTION.tabbedBar.navigable}"	alt="next" image=".\..\..\images\nextpage.gif"	action="#{PILP026_COMPOSITE_ACTION.tabbedBar.gotoNextTab}"	reRender="mypanel" /> <a4j:commandButton immediate="true"	disabled="#{PILP026_COMPOSITE_ACTION.tabbedBar.navigable}"	alt="last" image=".\..\..\images\lastRecord.gif"	action="#{PILP026_COMPOSITE_ACTION.tabbedBar.gotoLastTab}"	reRender="mypanel" /></td>	</tr> </table> </h:panelGroup></td> </tr> </table> </td> </tr> <tr><td colspan="3" width="100%" vAlign="top" height="20"><table width="100%" cellpadding="0" cellspacing="0" id="linkstable"><tr><td>
<h:outputLabel value="#{message.PILP026$PT_IL_POLICY$displayCaption}"/>
</td></tr></table></td></tr><tr><td colspan="3" width="100%" vAlign="top" height="20"><table width="100%" cellpadding="0"><tr></tr></table></td></tr><tr><td colspan="3"><div style="height:500px;overflow:auto;"><table cellpadding="0" cellspacing="0" width="100%"><tr><td>&nbsp;</td><td width="90%" vAlign="top">
<table id="bordertable" align="left" width="100%" ><tr><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_NO_LABEL}"
    for="POL_NO" id="POL_NO_LABEL" rendered="true" styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_NO$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_NO}"
    disabled="false" id="POL_NO" maxlength="40" rendered="true"
    required="false" style="height:23px;width:227px;"
    styleClass="forumRowHighlight"
    title="#{message.PILP026$PT_IL_POLICY$POL_NO$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_NO}"/>
</td><td>&nbsp;</td><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_ASSURED_NAME_LABEL}"
    for="POL_ASSURED_NAME" id="POL_ASSURED_NAME_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_ASSURED_NAME$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_ASSURED_NAME}"
    disabled="false" id="POL_ASSURED_NAME" maxlength="2000"
    rendered="true" required="false" style="height:23px;width:227px;"
    styleClass="forumRowHighlight"
    title="#{message.PILP026$PT_IL_POLICY$POL_ASSURED_NAME$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_ASSURED_NAME}"/>
</td></tr><tr><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_SUM_ASSURED_LABEL}"
    for="POL_LC_SUM_ASSURED" id="POL_LC_SUM_ASSURED_LABEL"
    rendered="true" styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_LC_SUM_ASSURED$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_SUM_ASSURED}"
    disabled="false" id="POL_LC_SUM_ASSURED" maxlength="19"
    rendered="true" required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_LC_SUM_ASSURED$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_LC_SUM_ASSURED}">
    <f:converter converterId="PELNumberFormatter"/>
</h:inputText>
</td><td>&nbsp;</td><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_FC_BASIC_PREM_LABEL}"
    for="POL_FC_BASIC_PREM" id="POL_FC_BASIC_PREM_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_FC_BASIC_PREM$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_FC_BASIC_PREM}"
    disabled="false" id="POL_FC_BASIC_PREM" maxlength="16"
    rendered="true" required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_FC_BASIC_PREM$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_FC_BASIC_PREM}">
    <f:converter converterId="PELNumberFormatter"/>
</h:inputText>
</td></tr><tr><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_BASIC_PREM_LABEL}"
    for="POL_LC_BASIC_PREM" id="POL_LC_BASIC_PREM_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_LC_BASIC_PREM$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_BASIC_PREM}"
    disabled="false" id="POL_LC_BASIC_PREM" maxlength="16"
    rendered="true" required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_LC_BASIC_PREM$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_LC_BASIC_PREM}">
    <f:converter converterId="PELNumberFormatter"/>
</h:inputText>
</td><td>&nbsp;</td><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_FC_ADDL_PREM_LABEL}"
    for="POL_FC_ADDL_PREM" id="POL_FC_ADDL_PREM_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_FC_ADDL_PREM$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_FC_ADDL_PREM}"
    disabled="false" id="POL_FC_ADDL_PREM" maxlength="16"
    rendered="true" required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_FC_ADDL_PREM$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_FC_ADDL_PREM}">
    <f:converter converterId="PELNumberFormatter"/>
</h:inputText>
</td></tr><tr><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_ADDL_PREM_LABEL}"
    for="POL_LC_ADDL_PREM" id="POL_LC_ADDL_PREM_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_LC_ADDL_PREM$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_LC_ADDL_PREM}"
    disabled="false" id="POL_LC_ADDL_PREM" maxlength="16"
    rendered="true" required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_LC_ADDL_PREM$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_LC_ADDL_PREM}">
    <f:converter converterId="PELNumberFormatter"/>
</h:inputText>
</td><td>&nbsp;</td><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_END_NO_IDX_LABEL}"
    for="POL_END_NO_IDX" id="POL_END_NO_IDX_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_END_NO_IDX$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_END_NO_IDX}"
    disabled="false" id="POL_END_NO_IDX" maxlength="11" rendered="true"
    required="false" style="height:23px;width:96px;"
    styleClass="forumRowHighlightNumeric"
    title="#{message.PILP026$PT_IL_POLICY$POL_END_NO_IDX$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_END_NO_IDX}"/>
</td></tr><tr><td id="td-background" align="left">
<h:outputLabel
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_END_NO_LABEL}"
    for="POL_END_NO" id="POL_END_NO_LABEL" rendered="true"
    styleClass="label" value="#{message.PILP026$PT_IL_POLICY$POL_END_NO$caption}"/>
</td><td align="left">
<h:inputText
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_POL_END_NO}"
    disabled="false" id="POL_END_NO" maxlength="40" rendered="true"
    required="false" style="height:23px;width:227px;"
    styleClass="forumRowHighlight"
    title="#{message.PILP026$PT_IL_POLICY$POL_END_NO$tooltip}" value="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.PT_IL_POLICY_BEAN.POL_END_NO}"/>
</td><td>&nbsp;</td> </tr> </table> </td>  <td width="10%" vAlign="top"><table><tr><td>
<h:commandButton
    binding="#{PILP026_COMPOSITE_ACTION.PT_IL_POLICY_ACTION_BEAN.COMP_UI_M_BUT_DELETE}"
    disabled="false" id="UI_M_BUT_DELETE" rendered="true"
    styleClass="button"
    title="#{message.PILP026$PT_IL_POLICY$UI_M_BUT_DELETE$tooltip}" value="#{message.PILP026$PT_IL_POLICY$UI_M_BUT_DELETE$caption}"/>
</td></tr>
</table></td></tr></table></div></td></tr><tr><td colspan="3" width="100%"><rich:toolBar styleClass="toolBarStyle" width="100%"><rich:toolBarGroup location="right" styleClass="toolBarGroupStyle">
<h:commandLink rendered="true" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\save.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$save}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\savenext.GIF"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$savenext}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\firstrec.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$firstrec}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\prevpage.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$prevpage}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\nextpage.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$nextpage}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\lastRecord.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$lastRecord}"/>
</h:commandLink>

<h:commandLink rendered="false" style="text-decoration:none" styleClass="toolbarCommandLinkStyle">
    <h:graphicImage styleClass="toolbarImageStyle" value=".\..\..\images\navigation.gif"/>
    <h:outputText styleClass="toolbaroutputTextStyle" value="#{menumessage.jsf$header$image$navigation}"/>
</h:commandLink>
</rich:toolBarGroup></rich:toolBar></td></tr></h:form></table><table cellpadding="0" cellspacing="0" width="100%"><tr><td><jsp:include page="../jsp/footer.jsp" /></td></tr></table></f:view></body></html>