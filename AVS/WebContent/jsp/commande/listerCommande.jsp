<%@include file="/jsp/tiles/taglib.jsp"%>
<!-- style css -->
<style>
.prix_titre {
	text-align: center;
	margin-top: -4.5%;
}

.prix {
	text-align: center;
	margin-top: -2%;
}
</style>
<div style="background-color: white; height: 100%; padding: 10px">
	<!-- fin du style -->

	<div class="commande">
		<h2>Commande</h2>
	</div>

	<div class="prix_titre">
		<h2>Prix</h2>
	</div>
	<logic:iterate name="listeCommande" id="commande" scope="request">
		<div>
			<html:link href="consulterCommande.do?id=${commande.idCommande}">	N°Commande
				<bean:write name="commande" property="numeroCommande" />
			</html:link>
			<br /> Date :
			<bean:write name="commande" property="date" />
			<div class="prix">
				Prix :
				<bean:write name="commande" property="montantAvecRemise" />
				euro
			</div>
		</div>
	</logic:iterate>
</div>