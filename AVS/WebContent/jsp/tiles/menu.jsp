<%@page import="presentation.users.action.ConnecterUserAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: gray; height: 100%; padding: 10px">
	<bean:define id="contextPath" value="<%=request.getContextPath()%>" />
	<html:link href="${contextPath}/listerProduitClient.do">
		<bean:message key="MENU.ListeDesProduitsClient" />
	</html:link>
	<br>
	<html:link href="${contextPath}/listerCommande.do">
		<bean:message key="MENU.ListeDesCommandes" />
	</html:link>
	<br>
	<html:link href="${contextPath}/voirConnecterUser.do">
		<bean:message key="MENU.SeConnecter" />
	</html:link>
</div>