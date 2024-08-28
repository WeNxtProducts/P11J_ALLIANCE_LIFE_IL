

<%@ page import = "java.util.*"%>
<%@ page import = "com.iii.apps.persistence.SimpleConnectionAgent"%>
<!-- <%@ page import = "javax.servlet.*"%>
<%@ page import = "javax.servlet.http.*"%>
<%@ page import = "javax.servlet.jsp.*"%> -->

<!-- Kill Applications- MuthuKrishnan -->

<html>

	<script language="javascript">
		function closeConnection(id) {			
			document.location.href = "ClientDetails.jsp?connectionId="+id;
		}
		function closeAllConnection() {
			document.location.href = "ClientDetails.jsp?closeAllConnection=true";
		}
	</script>

<%
			SimpleConnectionAgent simpleConnectionAgent = (SimpleConnectionAgent)application.getAttribute("connectionAgent");
			System.out.println("SimpleConnection Agent object is : "+simpleConnectionAgent);
%>
	<body>
		<table border="1">
		<tr>
			<th colspan=3>Total Connections: <%= simpleConnectionAgent.size()%></th>
		</tr>
			<tr>
				<th>Client ID</th>
				<th>DataBase URL</th>
				<th>DB Status</th>
				<th>Close</th>
			</tr>
			
	<%
		String connectionId = request.getParameter("connectionId");
		if(connectionId != null) {
			try{
				simpleConnectionAgent.close(connectionId);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String closeAll = request.getParameter("closeAllConnection");
		if("true".equals(closeAll)) {
			try{
				simpleConnectionAgent.closeAll();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Enumeration ids = simpleConnectionAgent.getClientIds();
		while(ids.hasMoreElements()){
			 String id = (String)ids.nextElement();
			 System.out.println(id) ;
			 String status = String.valueOf(simpleConnectionAgent.getConnection(id).isClosed());
			 if(status.equals("false")){
				 status ="true";
			 }
	%>
				<tr>
				<td><%= id %></td>
				<td><%= simpleConnectionAgent.getAllClientDetails(id) %></td>
				<td><%= status %></td> 
				<td><a href="javascript:closeConnection('<%=id%>')">Close</a></td> 
			</tr>
			
<%
	 }
%>
		<!--<tr ><td colspan='4'><a href="javascript:closeAllConnection()">Close All</a></td><tr>-->
		</table>
	</body>
</html>
