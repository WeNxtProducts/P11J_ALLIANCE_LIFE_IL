<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<script type="text/javascript">
function homePage(context){
	document.forms[0].method = "POST";
	document.forms[0].action = context+"/jsf/jsp/home.jsf";
	document.forms[0].submit();
}
</script>
<!-- [Bugid: MQC28 - davinci - Suppress F5 key 15-Jan-2008  -->
<script> 
	window.history.forward(1); 
	document.attachEvent("onkeydown", F5_handler); 
	function F5_handler(){ 
	switch (event.keyCode){ 
		case 116 : // 'F5' 
		event.returnValue = false; 
		event.keyCode = 0; 
		window.status = "Application security does not allow the usage of F5(Refresh) key!"; 
		break; 
		} 
	} 
</script>
<!-- Bugid: MQC28 - davinci - Suppress F5 key 15-Jan-2008] -->

<!-- [bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008-->
<script language="JavaScript"   >
	window.onbeforeunload = confirmUnload;
	function confirmUnload() {
		if((window.event.clientX<0) ||(window.event.clientY<0)){
			if (confirm("Do you want to exit?")) {
				document.getElementById('PEL_MENU:LOGOUT_button').click();
				return true;
			} else {
				return false;
			}
		}
	}
</script>
<!-- bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008]-->

<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/fun11.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/rightclick.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/js/altF4.js"></script>
<link href="${pageContext.request.contextPath}/resources/css/menu_life.css" rel="stylesheet"
	type="text/css">
<link href="${pageContext.request.contextPath}/resources/styles/login_styles.css" rel="stylesheet"
	type="text/css">
<!-- [bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008-->
	<h:form id="PEL_MENU" >
<!-- bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008]-->
		<jsp:include page="/jsf/jsp/header.jsp" />
<!-- [bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008-->
		<h:commandButton value="OK" id="LOGOUT_button" 
         		   styleClass="button" immediate="true"
         		  style="display: none"
                  action="#{PremiaMenuToolbar.logoutAction}">
           </h:commandButton>
<!-- bugid: PREMIAGDC-265437 - Aniesh 30-Dec-2008]-->

		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="0"
						id="topnav">
						<tr>
							<td width="35" valign="bottom">
								<img src="${pageContext.request.contextPath }/resources/images/home.jpg"
									width="35" height="27"/>
							</td>
							<td>
								<ul>
									<rich:dataList
											id="MENU_LEVEL_1" 
											value="#{PremiaMenuToolbar.firstLevel}" var="menuOneList">
										<c:choose>
											<c:when test="${!empty PremiaMenuToolbar.activeScreen}">
												<a4j:commandLink style="height: 28px;"
															value="#{menuOneList.name}" 
															action="#{PremiaMenuToolbar.setNavigationParameter}"
															styleClass="#{menuOneList.activeLink}">
													<f:param name="screenId" value="#{menuOneList.screenId}" />
													<f:param name="nodeId" value="#{menuOneList.nodeId}" />
													<f:param name="nodeLevel" value="#{menuOneList.nodeLevel}" />
													<rich:componentControl
																id="SCREEN_NAVI_PANEL_CONTROL"
																for="SCREEN_NAVI_PANEL" 
																operation="show" 
																event="onclick"/>
												</a4j:commandLink>
											</c:when>
											<c:otherwise>
												<h:commandLink style="height: 28px;" 
														value="#{menuOneList.name}"
														immediate="true" 
														action="#{PremiaMenuToolbar.menuItemAction}"
														styleClass="#{menuOneList.activeLink}">
													<f:param name="screenId" value="#{menuOneList.screenId}" />
													<f:param name="nodeId" value="#{menuOneList.nodeId}" />
													<f:param name="nodeLevel" value="#{menuOneList.nodeLevel}" />
												</h:commandLink>
											</c:otherwise>
										</c:choose>
									</rich:dataList>
								</ul>
							</td>
						</tr>
					</table>
					<c:if test="${!empty premiaMenu.menuTwo.menuItemList}">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							id="globalNav2 A">
							<tr>
								<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
										id="globalLink2">
									<tr>
										<c:if test="${premiaMenu.menuTwo.start>0}">
											<td align="left">
												<h:commandLink
													immediate="true"
													action="#{PremiaMenuToolbar.paginationAction}"
													value="#{PremiaMenuToolbar.left}">
													<f:param name="page" value="left"/>
													<f:param name="level" value="2"/>
												</h:commandLink>
											</td>
										</c:if>
										<td>
											<ul>
												<rich:dataList
														id="MENU_LEVEL_2" 
														value="#{PremiaMenuToolbar.secondLevel}" 
														var="menuTwoList">
													<c:choose>
														<c:when test="${!empty PremiaMenuToolbar.activeScreen}">
															<a4j:commandLink value="#{menuTwoList.name}" 
																		action="#{PremiaMenuToolbar.setNavigationParameter}"
																		styleClass="#{menuTwoList.activeLink}">
																<f:param name="screenId" value="#{menuTwoList.screenId}" />
																<f:param name="nodeId" value="#{menuTwoList.nodeId}" />
																<f:param name="nodeLevel" value="#{menuTwoList.nodeLevel}" />
																<rich:componentControl
																	id="SCREEN_NAVI_PANEL_CONTROL"
																	for="SCREEN_NAVI_PANEL" 
																	operation="show" 
																	event="onclick"/>
															</a4j:commandLink>
														</c:when>
														<c:otherwise>
															<h:commandLink value="#{menuTwoList.name}" 
																		action="#{PremiaMenuToolbar.menuItemAction}"
																		immediate="true"
																		styleClass="#{menuTwoList.activeLink}">
																<f:param name="screenId" value="#{menuTwoList.screenId}" />
																<f:param name="nodeId" value="#{menuTwoList.nodeId}" />
																<f:param name="nodeLevel" value="#{menuTwoList.nodeLevel}" />
															</h:commandLink>
														</c:otherwise>
													</c:choose>
												</rich:dataList>
											</ul>
										</td>
										<c:if
											test="${premiaMenu.menuTwo.start<premiaMenu.menuTwo.length-premiaMenu.menuTwo.increment}">
											<td align="right">
												<h:commandLink
														action="#{PremiaMenuToolbar.paginationAction}"
														immediate="true"
														value="#{PremiaMenuToolbar.right}">
													<f:param name="page" value="right"/>
													<f:param name="level" value="2"/>
												</h:commandLink>
											</td>
										</c:if>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</c:if>
					
					<c:if test="${!empty premiaMenu.menuThree.menuItemList}">
						<table width="100%" border="0" cellpadding="0" cellspacing="0"
							id="globalNav A">
							<tr>
								<td>
								<table width="100%" border="0" cellspacing="0" cellpadding="0"
										id="globalLink">
									<tr>
										<c:if test="${premiaMenu.menuThree.start>0}">
											<td align="left">
												<h:commandLink
													immediate="true"
													action="#{PremiaMenuToolbar.paginationAction}"
													value="#{PremiaMenuToolbar.left}">
													<f:param name="page" value="left"/>
													<f:param name="level" value="3"/>
												</h:commandLink>
											</td>
										</c:if>
										<td>
											<ul>
												<rich:dataList
														id="MENU_LEVEL_3" 
														value="#{PremiaMenuToolbar.thirdLevel}" 
														var="menuThreeList">
													<c:choose>
														<c:when test="${!empty PremiaMenuToolbar.activeScreen}">
															<a4j:commandLink value="#{menuThreeList.name}" 
																		action="#{PremiaMenuToolbar.setNavigationParameter}"
																		styleClass="#{menuThreeList.activeLink}">
																<f:param name="screenId" value="#{menuThreeList.screenId}" />
																<f:param name="nodeId" value="#{menuThreeList.nodeId}" />
																<f:param name="nodeLevel" value="#{menuThreeList.nodeLevel}" />
																<rich:componentControl
																	id="SCREEN_NAVI_PANEL_CONTROL"
																	for="SCREEN_NAVI_PANEL" 
																	operation="show" 
																	event="onclick"/>
															</a4j:commandLink>
														</c:when>
														<c:otherwise>
															<h:commandLink value="#{menuThreeList.name}" 
																		action="#{PremiaMenuToolbar.menuItemAction}"
																		immediate="true"
																		styleClass="#{menuThreeList.activeLink}">
																<f:param name="screenId" value="#{menuThreeList.screenId}" />
																<f:param name="nodeId" value="#{menuThreeList.nodeId}" />
																<f:param name="nodeLevel" value="#{menuThreeList.nodeLevel}" />
															</h:commandLink>
														</c:otherwise>
													</c:choose>
												</rich:dataList>
											</ul>
										</td>
										<c:if
											test="${premiaMenu.menuThree.start<premiaMenu.menuThree.length-premiaMenu.menuThree.increment}">
											<td align="right">
												<h:commandLink
														action="#{PremiaMenuToolbar.paginationAction}"
														immediate="true"
														value="#{PremiaMenuToolbar.right}">
													<f:param name="page" value="right"/>
													<f:param name="level" value="3"/>
												</h:commandLink>
											</td>
										</c:if>
									</tr>
								</table>
								</td>
							</tr>
						</table>
					</c:if>
				</td>
			</tr>
			<tr>
				<td>
					<rich:modalPanel id="SCREEN_NAVI_PANEL"  width="350" height="100">
					     <f:facet name="header">
					         <h:panelGroup>
					              <h:outputText value="Navigation" style="color: #FFFFFF; font-size: 14px;font-weight: bold;"></h:outputText>
					         </h:panelGroup>
					     </f:facet>
					     <f:facet name="controls">
					         <h:panelGroup>
					              <h:graphicImage value=".\..\..\images\close.png" 
					              		style="cursor:pointer" id="SCREEN_NAVI_PANEL_hidelink"/>
					              <rich:componentControl for="SCREEN_NAVI_PANEL"
						              	attachTo="SCREEN_NAVI_PANEL_hidelink" 
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
						          <h:commandButton value="OK" id="SCREEN_NAVI_PANEL_continuebutton" 
						          		   styleClass="button"
						          		   style="width:65px;height:20px;"
						                   action="#{PremiaMenuToolbar.confirmationModalPanel}">
						              <rich:componentControl for="SCREEN_NAVI_PANEL"
						                  attachTo="SCREEN_NAVI_PANEL_continuebutton" 
						                  operation="hide" event="onclick"/>
						          </h:commandButton>
						          &nbsp;
						          <a4j:commandButton value="Cancel"
						          		styleClass="button" 
						          		style="width:65px;height:20px;"
						          		id="SCREEN_NAVI_PANEL_cancelbutton" immediate="true">
						               <rich:componentControl for="SCREEN_NAVI_PANEL"
						               			attachTo="SCREEN_NAVI_PANEL_cancelbutton" 
						               			operation="hide" event="onclick"/>
						          </a4j:commandButton>
							</td>
							</tr>
						</table>
					</rich:modalPanel>
				</td>
			</tr>
		</table>
	</h:form>
