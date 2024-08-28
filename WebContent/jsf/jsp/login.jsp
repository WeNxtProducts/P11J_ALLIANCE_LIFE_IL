<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Page-Enter" content="BlendTrans(Duration=0.001)" />
<meta http-equiv="Page-Exit" content="BlendTrans(Duration=0.001)" />
<script type="text/javascript">
<!-- [ BugId:PREMIAGDC-265740 MMuthu 30-Dec-2008 During onload checking the browser settings --> 
function load() {
 	var bName=navigator.appName;
	var bversion=navigator.appVersion;
	var version=parseFloat(bversion);
	if ((bName=="Microsoft Internet Explorer")
		&& (version>=4)){
	}else{
		alert("Application is Suitable only for  Internet Explorer 6.0 and above.");
<!-- [BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any browser other than IE Ver 6 and above -->		
		document.getElementById('login:browserVersion').click();
<!-- BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any browser other than IE Ver 6 and above ]-->
		window.open('','_parent');
		window.close();
	}
}
</script>
<title>::: PREMIA LIFE :::</title>
<link href="./../../resources/css/login_life.css" rel="stylesheet"
	type="text/css">
</head>
<body onload="load()">
<!-- BugId:PREMIAGDC-265740 MMuthu 30-Dec-2008 During onload checking the browser settings ] -->
<f:view locale="#{sessionScope['pageLocale']}">
<!-- [BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any browser other than IE Ver 6 and above -->
	<h:form id="login">
		<f:loadBundle var="property" basename="login" />
		<h:commandButton 
			actionListener="#{loginManagedBean.preForm}"
			binding="#{loginManagedBean.browserVersion}" id="browserVersion"
			immediate="true" style="display: none" />
<!-- BugId:PREMIAGDC-265740 mmuthu 05-Jan-09 Blocking the application if any browser other than IE Ver 6 and above ]-->	
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="height" bgcolor="#FFFFFF">
			<tr>
				<td valign="top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td class="borderright" width="930">&nbsp;</td>
						<td class="borderright" width="242"><img
							src="./../../resources/images/login/dummy1.jpg" width="242"
							height="4" /></td>
						<td width="63">&nbsp;</td>
					</tr>
					<tr>
						<td class="borderright">&nbsp;</td>
						<td class="borderright">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td width="930" class="borderright">&nbsp;</td>
						<td width="242" class="borderright"><img
							src="./../../resources/images/login/Premia-Logo.jpg"
							alt="PREMIA " width="242" height="40" /></td>
						<td width="63"><img
							src="./../../resources/images/login/dummy.jpg" width="63"
							height="2" /></td>
					</tr>
					<tr>
						<td class="border" align="right"><img
							src="./../../resources/images/login/PREMIA-Image.jpg"
							alt="PREMIA LIFE" width="642" height="194" /></td>
						<td class="border" valign="top" style="background: #3CA0D4;">
						<table width="242" border="0" cellspacing="2" cellpadding="2">
							<tr>
								<td colspan="2" class="loginhead">Login Details</td>
							</tr>
							<tr>
								<td class="textheading">&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td width="34%" class="textheading"><h:outputLabel
									value="#{property.premia_login_label_username}"
									binding="#{loginManagedBean.userNameLabel}" for="username" /></td>
								<td width="66%"><h:inputText 
									value="#{loginManagedBean.loginBean.userName}" id="username"
									binding="#{loginManagedBean.userName}" required="false"
									validator="#{loginManagedBean.validateUserName}"
									styleClass="textinput">
									<a4j:support focus="password"
										actionListener="#{loginManagedBean.userNameAction}"
										event="onblur" 
										reRender="password, errorMessages, errorPanel" 
										immediate="true" />
								</h:inputText></td>
							</tr>
							<tr>
								<td width="34%" class="textheading"><h:outputLabel
									value="#{property.premia_login_label_password}"
									binding="#{loginManagedBean.passwordLabel}" /></td>
								<td width="66%"><h:inputSecret
									value="#{loginManagedBean.loginBean.password}" id="password"
									binding="#{loginManagedBean.password}" required="false" redisplay="true"
									validator="#{loginManagedBean.validatePassword}"
									styleClass="textinput">
									<a4j:support
										actionListener="#{loginManagedBean.passwordAction}"
										event="onblur" reRender="errorMessages,errorPanel" immediate="true" />
								</h:inputSecret></td>
							</tr>
							<tr>
								<td width="34%" class="textheading"><h:outputLabel
									value="#{property.premia_login_company_code}"
									binding="#{loginManagedBean.companyCodeLabel}" /></td>
								<td width="66%"><h:inputText id="companyCode"
									binding="#{loginManagedBean.companyCodeBox}"
									value="#{loginManagedBean.loginBean.companyCode}"
									required="false" rendered="true"
									styleClass="textinput"
									validator="#{loginManagedBean.validateCompCode}">
									<rich:suggestionbox height="100" width="150" reRender="errorPanel"
										suggestionAction="#{loginManagedBean.getCompCodeList}"
										for="companyCode" var="compCode" immediate="true">
										<h:column>
											<h:outputText value="#{compCode.companyCode}" />
										</h:column>
										<h:column>
											<h:outputText value="#{compCode.companyCodeDesc}" />
										</h:column>
									</rich:suggestionbox>
									<a4j:support
										actionListener="#{loginManagedBean.compCodeAction}"
										event="onblur" reRender="errorMessages" immediate="true" />
								</h:inputText></td>
							</tr>
							<tr>
								<td width="34%" class="textheading"><h:outputLabel
									value="#{property.premia_login_division_code}"
									binding="#{loginManagedBean.divisionCodeLabel}" /></td>
								<td width="66%"><h:inputText id="divisionCode"
									binding="#{loginManagedBean.divisionCodeBox}"
									value="#{loginManagedBean.loginBean.divisionCode}"
									required="false" rendered="true"
									styleClass="textinput"
									validator="#{loginManagedBean.validateDivnCode}">
									<rich:suggestionbox height="100" width="150" reRender="errorPanel"
										suggestionAction="#{loginManagedBean.getDivCodeList}"
										for="divisionCode" var="divnCode" immediate="true">
										<h:column>
											<h:outputText value="#{divnCode.divisionCode}" />
										</h:column>
										<h:column>
											<h:outputText value="#{divnCode.divisionCodeDesc}" />
										</h:column>
									</rich:suggestionbox>
									<a4j:support
										actionListener="#{loginManagedBean.divnCodeAction}"
										event="onblur" reRender="errorMessages" immediate="true" />
								</h:inputText></td>
							</tr>
							<tr>
								<td width="34%" class="textheading"><h:outputLabel
									value="#{property.premia_login_department_code}"
									binding="#{loginManagedBean.departmentCodeLabel}" /></td>
								<td width="66%"><h:inputText id="departmentCode"
									value="#{loginManagedBean.loginBean.departmentCode}"
									binding="#{loginManagedBean.departmentCodeBox}"
									required="false" rendered="true"
									styleClass="textinput"
									validator="#{loginManagedBean.validateDeptCode}">
									<rich:suggestionbox height="100" width="150" reRender="errorPanel"
										suggestionAction="#{loginManagedBean.getDepartCodeList}"
										for="departmentCode" var="deptCode" immediate="true">
										<h:column>
											<h:outputText value="#{deptCode.departmentCode}" />
										</h:column>
										<h:column>
											<h:outputText value="#{deptCode.departmentCodeDesc}" />
										</h:column>
									</rich:suggestionbox>
									<a4j:support
										actionListener="#{loginManagedBean.deptCodeAction}"
										event="onblur" reRender="errorMessages" immediate="true" />
								</h:inputText></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>
								<h:selectOneMenu value="#{loginManagedBean.loginBean.pageLocale}"
										style="font-family: Arial; font-size: 10px; font-weight: bold;">
									<f:selectItems value="#{loginManagedBean.langConst.langCodeList}"/>
								</h:selectOneMenu>
								</td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td><h:commandButton
										value="#{property.premia_login_button_login}" 
										style="background-color: #E4E4E4; height: 18px; width: 60px; font-family: Arial; font-size: 10px; font-weight: bold;"
										type="submit" 
										action="#{loginManagedBean.loginAction}"/>
									<h:commandButton
										value="#{property.premia_login_button_reset}" 
										style="background-color: #E4E4E4; height: 18px; width: 60px; font-family: Arial; font-size: 10px; font-weight: bold;"
										type="reset"/></td>
							</tr>
							<tr>
								<td>&nbsp;</td>
								<td>&nbsp;</td>
							</tr>
						</table>
						<h:panelGrid id="errorPanel">
							<h:outputText id="errorMessages" value="#{loginManagedBean.errorMessages}"
								binding="#{loginManagedBean.loginMessageComp}"
								style="color: red;"
								escape="false" 
								rendered="true"/>
							<h:outputText value="#{loginManagedBean.errorMap['current']}" 
								style="color: red;" escape="false"/>
						</h:panelGrid>
						</td>
						<td class="bordercorner" style="background: #88C140;">&nbsp;</td>
					</tr>
					<tr>
						<!-- [BugId:FixPREMIAGDC-266184 MMuthu 02-Jan-2009 Value getting from login message properties -->
						<td class="copyright">
						 <h:outputLabel id="loginfooter" value="#{property.pel_login_footer}"/></td>
<!-- BugId:FixPREMIAGDC-266184 MMuthu 02-Jan-2009  Value getting from login message properties ]  -->
						<td class="borderright"
							style="background: url(./../../resources/images/login/Developedby.jpg) no-repeat center; height: 35px; width: 182px;">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="borderright">&nbsp;</td>
						<td class="borderright">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td class="borderright">&nbsp;</td>
						<td class="borderright">&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
	</h:form>
</f:view>
</body>
</html>
