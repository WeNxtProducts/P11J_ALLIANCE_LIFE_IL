<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<HEAD>
<meta http-equiv="Page-Enter" content="BlendTrans(Duration=0.001)" />
<meta http-equiv="Page-Exit" content="BlendTrans(Duration=0.001)" />
</HEAD>
<link href="${pageContext.request.contextPath}/resources/styles/login_styles.css" rel="stylesheet"
	type="text/css">
<f:loadBundle basename="login" var="message12" />
<table width="100%" border="0" cellpadding="0" cellspacing="0"
	id="masthead">
	<tr>
		<td width="20%">
			<h:outputLabel value="#{message12.project_name}"/>
			<sup><h:outputLabel value="#{message12.trade_mark}"/></sup>
			<h:outputLabel value="#{message12.product_name}"></h:outputLabel>
		</td>
		<td width="35%" align="center">
			<h:outputLabel value="#{message12.premia_login_label_welcome}"></h:outputLabel>
			<c:out value="${sessionScope['GLOBAL.M_USER_ID']}"/>
		</td>
		<td width="35%" align="right">
			<rich:modalPanel id="SEARCH_SCREEN_NAVI_PANEL"  width="350" height="100">
			     <f:facet name="header">
			         <h:panelGroup>
			              <h:outputText value="Navigation" style="color: #FFFFFF; font-size: 14px;font-weight: bold;"></h:outputText>
			         </h:panelGroup>
			     </f:facet>
			     <f:facet name="controls">
			         <h:panelGroup>
			              <h:graphicImage value=".\..\..\images\close.png" 
			              		style="cursor:pointer" id="SEARCH_SCREEN_NAVI_PANEL_hidelink"/>
			              <rich:componentControl for="SEARCH_SCREEN_NAVI_PANEL"
				              	attachTo="SEARCH_SCREEN_NAVI_PANEL_hidelink" 
				              	operation="hide" event="onclick"/>
			         </h:panelGroup>
			     </f:facet>
				<table align="center">
					<tr align="center">
						<td>
							<h:outputText value="Any unsaved data will be lost ?"/>
						</td>
					</tr>
					<tr align="center">
					<td>
				          <h:commandButton value="OK" id="SEARCH_SCREEN_NAVI_PANEL_continuebutton" 
				          		   styleClass="button"
				          		   style="width:65px;height:20px;"
				                   action="#{PremiaMenuToolbar.setSearchScreen}">
				              <rich:componentControl for="SEARCH_SCREEN_NAVI_PANEL"
				                  attachTo="SEARCH_SCREEN_NAVI_PANEL_continuebutton" 
				                  operation="hide" event="onclick"/>
				          </h:commandButton>
				          &nbsp;
				          <a4j:commandButton value="Cancel"
				          		styleClass="button" 
				          		style="width:65px;height:20px;"
				          		id="SEARCH_SCREEN_NAVI_PANEL_cancelbutton" immediate="true">
				               <rich:componentControl for="SEARCH_SCREEN_NAVI_PANEL"
				               			attachTo="SEARCH_SCREEN_NAVI_PANEL_cancelbutton" 
				               			operation="hide" event="onclick"/>
				          </a4j:commandButton>
					</td>
					</tr>
				</table>
			</rich:modalPanel>
			<h:outputLabel value="#{message12.menu_search_label}"></h:outputLabel>
			<h:inputText rendered="true" id="MENU_SEARCH" 
					style="width: 180px; height: 20px;"
					value="#{PremiaMenuToolbar.menuSearchBean.MENU_OPTION_DESC}">
			</h:inputText>
			<rich:suggestionbox id="MENU_SEARCH_SB"
					height="200" width="250" 
					selfRendered="true"
					suggestionAction="#{PremiaMenuToolbar.getScreenList}" 
					for="MENU_SEARCH" var="menuSearch" immediate="true">
				<h:column>
					<h:outputText value="#{menuSearch.MENU_OPTION_DESC}"/>
				</h:column>
				<a4j:support immediate="true"
							actionListener="#{PremiaMenuToolbar.menuSearchAction}"
							event="onselect">
				</a4j:support>
			</rich:suggestionbox>
			<c:choose>
				<c:when test="${!empty PremiaMenuToolbar.activeScreen}">
					<a4j:commandLink onclick="Richfaces.showModalPanel('SEARCH_SCREEN_NAVI_PANEL');"
								style="cursor:pointer; color:#FFFFFF;">
						<h:graphicImage value=".\..\..\images\Lov.gif"/>
					</a4j:commandLink>
				</c:when>
				<c:otherwise>
					<h:commandLink action="#{PremiaMenuToolbar.setSearchScreen}"
								style="cursor:pointer; color:#FFFFFF;">
						<h:graphicImage value=".\..\..\images\Lov.gif"/>
					</h:commandLink>
				</c:otherwise>
			</c:choose>
		</td>
		<td width="10%">
		<a4j:status startText=" #{commonmsg.status}" layout="block" startStyle="background-color:;height: 20px;font-weight: bold; color: #004080" >
		<f:facet name="start">
		<h:graphicImage  value=".\..\..\images\fadingArrowIndicator.gif"/>
		</f:facet>
		</a4j:status>
		</td>
		<td width="10%" align="right">
			<a4j:commandLink id="COMP_LOGOUT" 
						value="Logout" 
						style="cursor:pointer; color:#FFFFFF;">
					<rich:componentControl
						id="LOGOUT_COMP_CONTROL"
						for="LOGOUT_PANEL" 
						attachTo="COMP_LOGOUT" 
						operation="show" 
						event="onclick"/>
			</a4j:commandLink>
			<rich:modalPanel id="LOGOUT_PANEL" width="350" height="100">
			     <f:facet name="header">
			         <h:panelGroup>
			              <h:outputText value="Logout" style="color: #FFFFFF; font-size: 14px;font-weight: bold;"></h:outputText>
			         </h:panelGroup>
			     </f:facet>
			     <f:facet name="controls">
			         <h:panelGroup>
			              <h:graphicImage value=".\..\..\images\close.png" 
			              		style="cursor:pointer" id="LOGOUT_PANEL_hidelink"/>
			              <rich:componentControl for="LOGOUT_PANEL" 
				              	attachTo="LOGOUT_PANEL_hidelink" 
				              	operation="hide" event="onclick"/>
			         </h:panelGroup>
			     </f:facet>
				<table align="center">
					<tr align="center">
						<td>
							<h:outputText value="Do you want to exit from the application?"/>
						</td>
					</tr>
					<tr align="center">
					<td>
				          <h:commandButton value="OK" id="LOGOUT_PANEL_continuebutton" 
				          		   styleClass="button"
				          		   style="width:65px;height:20px;"
				                   action="#{PremiaMenuToolbar.logoutAction}">
				              <rich:componentControl for="LOGOUT_PANEL" 
				                  attachTo="LOGOUT_PANEL_continuebutton" 
				                  operation="hide" event="onclick"/>
				          </h:commandButton>
				          &nbsp;
				          <a4j:commandButton value="Cancel"
				          		styleClass="button" 
				          		style="width:65px;height:20px;"
				          		id="LOGOUT_PANEL_cancelbutton" immediate="true">
				               <rich:componentControl for="LOGOUT_PANEL" 
				               			attachTo="LOGOUT_PANEL_cancelbutton" 
				               			operation="hide" event="onclick"/>
				          </a4j:commandButton>
					</td>
					</tr>
				</table>
			</rich:modalPanel>
		</td>
	</tr>
</table>
