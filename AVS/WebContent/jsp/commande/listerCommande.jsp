<%@include file="/jsp/tiles/taglib.jsp"%>
<link type="text/css" rel="stylesheet"
	href="<c:url value="/css/styleListerCommande.css"/>" />
<div style="background-color: #D65858; height: 100%; padding: 10px">
	<p>Commande</p>
	<br /> <br />
	<logic:iterate name="listeCommande" id="commande" scope="request">

		<div>
			<html:link href="consulterCommande.do?id=${commande.idCommande}">
				<bean:write name="commande" property="numeroCommande" />
			</html:link>
			<br />
			<bean:write name="commande" property="date" />
			<div class="gauche">
				<bean:write name="commande" property="montantAvecRemise" />
			</div>
		</div>
	</logic:iterate>
</div>