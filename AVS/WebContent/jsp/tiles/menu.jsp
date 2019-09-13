<%@page import="presentation.users.action.ConnecterUserAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: gray; height: 100%; padding: 10px">
	<html:link href="http://localhost:8080/AVS/listerProduitClient.do">
		<bean:message key="MENU.ListeDesProduitsClient" />
	</html:link>
	<br>
	<html:link href="http://localhost:8080/AVS/voirConnecterUser.do">
		<bean:message key="MENU.SeConnecter" />
	</html:link>
</div>