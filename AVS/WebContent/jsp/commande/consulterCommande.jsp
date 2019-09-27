<%@include file="/jsp/tiles/taglib.jsp"%>
<!-- style css -->
<style>
.adress {
	text-align: center;
}

</style>
<div style="background-color: white; height: 100%">

	<bean:message key="CDE_01.Commande.NumeroCommande" />:
	<bean:write name="consulterCommande" property="numeroCommande" />

	<table style="width: 100%">
		<tr>
			<th><bean:message key="CDE_01.Commande.AdresseLivraison" /></th>
			<th><bean:message key="CDE_01.Commande.AdresseFacturation" /></th>
		</tr>
		<tr class="adress">
			<td><bean:write name="consulterCommande"
					property="adresseLivraison" /></td>
			<td><bean:write name="consulterCommande"
					property="adresseFacturation" /></td>
		</tr>
		<tr>
			<th><bean:message key="CDE_01.Commande.Produit" /></th>
			<th><bean:message key="CDE_01.Commande.PrixUnitaire" /></th>
			<th><bean:message key="CDE_01.Commande.Quantite" /></th>
			<th><bean:message key="CDE_01.Commande.Prix" /></th>
		</tr>

		<logic:iterate id="mapQttPrix" name="consulterCommande"
			property="mapProduitVenduDto" scope="request">

			<bean:define id="produitVenduDto" name="mapQttPrix" property="key"></bean:define>
			<bean:define id="quantitePrix" name="mapQttPrix" property="value"></bean:define>

			<%
			    //TODO voir le retour pour le lien retour
			%>
			<tr>
				<td><html:link
						href="consulterProduit.do?id=${produitVenduDto.idProduitHistorise}&retour=commande">
						<html:img style="width:100px; height:100px;"
							src="${pageContext.request.contextPath}/afficherImage.do?urlImage=${produitVenduDto.image}" />
					</html:link></td>
				<td>${produitVenduDto.reference}</td>
				<td>${produitVenduDto.prix}</td>
				<td>${quantitePrix.quantite}</td>
				<td>${quantitePrix.prixParTypeProduit}</td>
			</tr>
		</logic:iterate>
		<tr>

			<logic:notEqual name="consulterCommande" property="remise"
				value="0,00">
			Total sans remise	<td><bean:write name="consulterCommande"
						property="montantSansRemise" /></td>
			</logic:notEqual>
		</tr>

		<tr>
			<logic:notEqual name="consulterCommande" property="remise"
				value="0,00">
				<td>Remise de 10% <bean:write name="consulterCommande"
						property="remise" />
				</td>
			</logic:notEqual>
		</tr>
		<tr>

			<td><bean:write name="consulterCommande"
					property="montantAvecRemise" /></td>
		</tr>

	</table>



</div>
