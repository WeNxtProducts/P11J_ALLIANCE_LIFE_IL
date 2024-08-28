<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html>
<head>
<LINK href=".\..\..\styles\premia_life.css" rel="stylesheet"
	type="text/css">
<LINK href=".\..\..\styles\LoginStyles.css" rel="stylesheet"
	type="text/css">
<LINK href=".\..\..\styles\Block_Navigation.css" rel="stylesheet"
	type="text/css">
	
</head>
<body>


<f:view locale="#{sessionScope['pageLocale']}">
	<f:loadBundle basename="messageProperties_PILT002_APAC" var="message" />
	<f:loadBundle basename="menu" var="menumessage" />

	<table width="100%" cellpadding="0" cellspacing="0"	border="0">
	<tr>
		<td colspan="3"><jsp:include page="../jsp/menu.jsp" /></td>
	</tr>
	<h:form id="COPY">
			<tr>
				<td colspan="3" width="100%" vAlign="top">
				<table width="100%" id="toolbartable" cellpadding="0" cellspacing="0"	border="0">
					<tr>
						<td>
						<rich:toolBar styleClass="toolBarStyle" width="100%">
							<rich:toolBarGroup styleClass="toolBarGroupStyle">
								<h:commandLink style="text-decoration:none" styleClass="toolbarCommandLinkStyle"
									action="#{FileUploadActionBean.goBack}" immediate="true">
									<h:graphicImage style="border: thin solid white" styleClass="toolbarImageStyle"
										value=".\..\..\images\back.png" />
									<h:outputText value="#{menumessage.jsf$header$image$back}" styleClass="toolbaroutputTextStyle"/>
								</h:commandLink> <h:commandLink style="text-decoration:none" styleClass="toolbarCommandLinkStyle"
									action="#{FileUploadActionBean.saveButtonClickAction}">
									<h:graphicImage style="border: thin solid white" styleClass="toolbarImageStyle"
										value=".\..\..\images\save.gif" />
									<h:outputText value="#{menumessage.jsf$header$image$save}" styleClass="toolbaroutputTextStyle" />
								</h:commandLink> <h:commandLink style="text-decoration:none" styleClass="toolbarCommandLinkStyle"
									action="#{FileUploadActionBean.deleteButtonAction}">
									<h:graphicImage style="border: thin solid white" styleClass="toolbarImageStyle"
										value=".\..\..\images\deleteRecord.gif" />
									<h:outputText
										value="#{menumessage.jsf$header$image$deleteRecord}" styleClass="toolbaroutputTextStyle" />
								</h:commandLink>
							</rich:toolBarGroup>
						</rich:toolBar>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" width="100%" vAlign="top" height="20">
				<table width="100%" id="errormsgtable" cellspacing="0">
					<tr>
						<td>
							<rich:simpleTogglePanel id="errorPanel"
								switchType="client" opened="false">
								<f:facet name="header">
									<h:outputText id="err"
										styleClass="#{FileUploadActionBean.messageStyle}"
										value="#{commonmsg.errorPanel$heading} #{FileUploadActionBean.errorMap['current'] !=null? FileUploadActionBean.errorMap['current']:FileUploadActionBean.warningMap['current']}" />
								</f:facet>
								<h:outputText id="errorMessages"
									value="#{FileUploadActionBean.errorMessages}"
									styleClass="ErrorMessages" escape="false" />
								<h:messages styleClass="ErrorMessages" id="msg"
									rendered="#{FileUploadActionBean.globalMsgRender}" />
								<h:outputText id="warningMessages"
									value="#{FileUploadActionBean.warningMessages}"
									styleClass="WarningMessages" escape="false" />
							</rich:simpleTogglePanel>
						</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" width="100%" vAlign="top" height="20">
				<table width="100%" id="linkstable" cellpadding="0" cellspacing="0"	border="0">
					<tr>
						<td>UPLOAD</td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" align="center">
				<table width="90%">
					<tr>
						<td width="90%" vAlign="top">
						<table id="bordertable" align="left" width="100%">
							<tr>
								<td width="100%" align="center"><rich:dataTable
									id="uploadTable" value="#{FileUploadActionBean.dataTableList}"
									var="valueBean" rows="3"
									binding="#{FileUploadActionBean.dataTableComponent}"
									width="100%">
									<rich:column>
										<f:facet name="Select">
											<h:outputText styleClass="forumRowHighlight" value="Select" />
										</f:facet>
										<h:selectBooleanCheckbox id="checkBox"
											value="#{valueBean.checkBox}">
											<a4j:support event="onclick"
												actionListener="#{FileUploadActionBean.checkBoxClickAction}"
												immediate="true">
											</a4j:support>
										</h:selectBooleanCheckbox>
									</rich:column>
									
									<!-- [ Added for grid implementation change, Added by: Ashutosh 	Sharma, Dated: 17-Feb-2009 -->
									<rich:column rendered="true" styleClass="gridsaveColoumn">
										<f:facet name="header">
											<h:outputText styleClass="label" value="#{commonmsg.IL_GRID$SAVE_COLUMN_HEADER$caption}" />
										</f:facet>
										<a4j:commandLink style="text-decoration:none" disabled="false" immediate="true" reRender="errorPanel" 
											title="#{commonmsg.IL_GRID$UI_M_BUT_RECORD_SAVE$title}"
											action="#{FileUploadActionBean.saveCurrentRecord}">
												<h:graphicImage style="border: thin solid white" value=".\..\..\images\insupd.gif" />
												<h:outputText value="#{commonmsg.IL_GRID$UI_M_BUT_RECORD_SAVE$caption}" />
										</a4j:commandLink>
									</rich:column>
									<!-- Added for grid implementation change, Added by: Ashutosh 	Sharma, Dated: 17-Feb-2009 ] -->
	
									<rich:column>
										<f:facet name="header">
											<h:outputText styleClass="forumRowHighlight" value="Remarks" />
										</f:facet>
										<h:inputTextarea id="remarks" styleClass="forumRowHighlight"
											value="#{valueBean.LIMG_REMARKS}" title="Enter Remarks"
											cols="90" rows="2">
											<a4j:support event="onblur" immediate="true"
												reRender="errorPanel"
												actionListener="#{FileUploadActionBean.setRemark}">
											</a4j:support>
										</h:inputTextarea>
									</rich:column>
									<rich:column width="100px" id="col">
										<!-- ModalPanel for Confirmation Dialog -->
										<rich:modalPanel id="panel" height="525" width="405"
											style="width:750px; height:750px;">
											<!-- Confirmation dialog title bar -->
											<f:facet name="header">
												<h:panelGroup>
													<!-- Title to be displayed in confirmation dialog -->
													<h:outputText value="Image Details"></h:outputText>
												</h:panelGroup>
											</f:facet>
											<!-- Confirmation dialog header controls -->
											<f:facet name="controls">
												<h:panelGroup>
													<!-- Control image for window close -->
													<h:graphicImage value=".\..\..\images\close.png"
														style="cursor:pointer" id="hidelink" />
													<!-- Control to close/hide the confirmation dialog -->
													<rich:componentControl for="panel" attachTo="hidelink"
														operation="hide" event="onclick" />
												</h:panelGroup>
											</f:facet>
											<rich:panel style="height:400px;width:380px">
												<!-- Confirmation dialog body -->
												<!-- Confirmation message -->

												<center><rich:panel>
													<a4j:mediaOutput id="modalPanelImage" element="img"
														value="#{valueBean}"
														createContent="#{FileUploadActionBean.paint}"
														cacheable="false" standby="Loading...Please Wait"
														style="width:300px;height:300px">

													</a4j:mediaOutput>
												</rich:panel> <rich:panel style="height:100px;overflow: auto">
													<h:outputLabel styleClass="label" value="Remarks : " />
													<h:outputLabel value="#{valueBean.LIMG_REMARKS}" />
												</rich:panel> <br>
												<!-- Confirmation dialog control buttons --> <!-- Rejection button with dialog close(do nothing) control component -->
												<a4j:commandButton value="Close" id="closebutton"
													immediate="true" styleClass="button">
													<rich:componentControl for="panel" attachTo="closebutton"
														operation="hide" event="onclick" />
												</a4j:commandButton></center>
											</rich:panel>
										</rich:modalPanel>


										<h:outputLink value="#" id="link" title="hello">
											<a4j:mediaOutput element="img" mimeType="#{valueBean.mime}"
												createContent="#{FileUploadActionBean.paint}"
												value="#{valueBean}" style="width:50px; height:50px;"
												cacheable="false" standby="Loading...Please Wait">
											</a4j:mediaOutput>
											<rich:componentControl for="panel" attachTo="link"
												operation="show" event="onclick" />
										</h:outputLink>
									</rich:column>
									
									<!-- [ Added for grid implementation change, Added by: Ashutosh 	Sharma, Dated: 17-Feb-2009 -->
									<rich:column rendered="true" styleClass="gridsaveColoumn">
										<f:facet name="header">
											<h:outputText styleClass="label" value="#{commonmsg.IL_GRID$SAVE_COLUMN_HEADER$caption}" />
										</f:facet>
										<a4j:commandLink style="text-decoration:none" disabled="false" immediate="true" reRender="errorPanel" 
											title="#{commonmsg.IL_GRID$UI_M_BUT_RECORD_SAVE$title}"
											action="#{FileUploadActionBean.saveCurrentRecord}">
												<h:graphicImage style="border: thin solid white" value=".\..\..\images\insupd.gif" />
												<h:outputText value="#{commonmsg.IL_GRID$UI_M_BUT_RECORD_SAVE$caption}" />
										</a4j:commandLink>
									</rich:column>
									<!-- Added for grid implementation change, Added by: Ashutosh 	Sharma, Dated: 17-Feb-2009 ] -->
									
									<f:facet name="footer">
										<rich:datascroller id="FILE_UPLOAD_SCROLL" align="left"
											page="#{FileUploadActionBean.currPage}">
										</rich:datascroller>
									</f:facet>
								</rich:dataTable></td>
							</tr>
							<tr>
								<td colspan="5" align="left" width="100%">
								<TABLE width="100%" id="globalLink" cellpadding="0" cellspacing="0">
									<TR>
									<TD>
									<h:panelGroup id="mypanel" style="border:0">
										<h:outputText styleClass="forumRowHighlight" value="#{commonmsg.FILE_UPLOAD$SUPPORTED_FILE_EXTENSIONS$caption} #{commonmsg.FILE_UPLOAD$SUPPORTED_FILE_EXTENSIONS}" />
									</h:panelGroup>
									</TD>
									</TR>
								</TABLE>
								</td>
							</tr>
							<tr>
								<td align="left" width="100%">
									<rich:fileUpload
									acceptedTypes="#{commonmsg.FILE_UPLOAD$SUPPORTED_FILE_EXTENSIONS}"
									maxFilesQuantity="#{FileUploadActionBean.maxUploadsAllowed}"
									binding="#{FileUploadActionBean.fileUploadComponent}"
									autoclear="false" 
									listHeight="180px" 
									listWidth="100%"
									id="fileupload"
									fileUploadListener="#{FileUploadActionBean.uploadAction}">
									<f:facet name="label">
										<h:outputText
											value="{_KB}KB from {KB}KB uploaded --- {mm}:{ss}" />
									</f:facet>
									<a4j:support event="onuploadcomplete" reRender="uploadTable" />
								</rich:fileUpload></td>
							</tr>
							<tr>
								<td colspan="5" width="100%">
								<hr color="black" />
								</td>
							</tr>

						</table>
						</td>
					</tr>
				</table>

				<table width="100%">
					<tr>
						<td><jsp:include page="../jsp/footer.jsp" /></td>
					</tr>
				</table>

				</td>
			</tr>
		</table>
	</h:form>
</f:view>

</body>
</html>