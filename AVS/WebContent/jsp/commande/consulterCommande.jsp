<%@include file="/jsp/tiles/taglib.jsp"%>
<!-- style css -->
<style>
.adress {
	text-align: center;
}

produit {
	text-align: center;
}
</style>
<div style="background-color: white; height: 100%">

	N°Commande :
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
		<logic:iterate id="consulterCommande" property="mapProduitVenduDto">

			<bean:define id="produitVenduDto" name="mapProduitVenduDto"
				property="key"></bean:define>
			<bean:define id="quantitePrix" name="mapProduitVenduDto"
				property="value"></bean:define>


		</logic:iterate>

	</table>



</div>
