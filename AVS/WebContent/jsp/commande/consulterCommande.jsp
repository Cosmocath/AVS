<%@include file="/jsp/tiles/taglib.jsp"%>
<!-- style css -->
<style>
.adress {
	text-align: center;
}
</style>
<div style="background-color: white; height: 100%">
	<%
	    //TODO bean message de panier valider a mettre + message a ajouter lors de l action du panier + les properties 
	%>
	<bean:message key="CDE_01.Commande.NumeroCommande" />
	:
	<bean:write name="consulterCommande" property="numeroCommande" />

	<table style="width: 100%">
		<tr>
			<th colspan="3"><bean:message
					key="CDE_01.Commande.AdresseLivraison" /></th>
			<th colspan="3"><bean:message
					key="CDE_01.Commande.AdresseFacturation" /></th>
		</tr>
		<tr class="adress">
			<td colspan="3"><bean:write name="consulterCommande"
					property="adresseLivraison" /></td>
			<td colspan="3"><bean:write name="consulterCommande"
					property="adresseFacturation" /></td>
		</tr>
		<tr>
			<th colspan="2"><bean:message key="CDE_01.Commande.Produit" /></th>
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
				<td align="center"><html:link
						href="consulterProduit.do?id=${produitVenduDto.idProduitHistorise}&retour=commande">
						<html:img style="width:100px; height:100px;"
							src="${pageContext.request.contextPath}/afficherImage.do?urlImage=${produitVenduDto.image}" />
					</html:link></td>
				<td>${produitVenduDto.reference}</td>
				<td align="center">${produitVenduDto.prix}</td>
				<td align="center">${quantitePrix.quantite}</td>
				<td align="center">${quantitePrix.prixParTypeProduit}</td>
			</tr>
		</logic:iterate>
		<tr align="right">

			<logic:notEqual name="consulterCommande" property="remise"
				value="0,00">
				<td colspan="4" align="right">Total sans remise</td>
				<td align="center"><bean:write name="consulterCommande"
						property="montantSansRemise" /></td>
			</logic:notEqual>
		</tr>

		<tr>
			<logic:notEqual name="consulterCommande" property="remise"
				value="0,00">
				<td colspan="4" align="right">Remise de 10%</td>
				<td align="center"><bean:write name="consulterCommande"
						property="remise" /></td>
			</logic:notEqual>
		</tr>
		<tr>
			<td colspan="4" align="right">Total</td>
			<td align="center"><bean:write name="consulterCommande"
					property="montantAvecRemise" /></td>
		</tr>

	</table>



</div>
