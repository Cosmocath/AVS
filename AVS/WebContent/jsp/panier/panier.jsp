<%@page import="presentation.panier.action.VoirPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div
	style="background-color: white; height: 100%">
	<h1>Panier</h1>
	<table style="width: 100%; text-align: center">
		<tr>
			<th>Designation</th><!-- produitDto -->
			<th>Référence</th><!-- produitDto -->
			<th>Quantite</th>
			<th>Prix unitaire</th>
			<th>Modifier Quantité</th>
			<th>Prix total</th>
			<th></th>
		</tr>
		<logic:iterate id="mapPanierQte" name="monPanierDto" scope="session" property="mapDesProduitsQte">
			<bean:define id="produitDto" name="mapPanierQte" property="key"></bean:define>
			<bean:define id="quantiteProduit" name="mapPanierQte"
				property="value"></bean:define>
				
			<tr>
				<td>${produitDto.designation}</td>
				<td>${produitDto.reference}</td>
				<td>${quantiteProduit}</td>
				<td>${produitDto.prix}</td>
				<td>
					<button type="button" onclick="ajouterQuantite">+</button>
					<button type="button" onclick="diminuerQuantite">-</button>
				</td>
				<td>${quantiteProduit*produitDto.prix}</td>
				<td>
					<button type="button" onclick="supprimerProduit">Supprimer</button>
				</td>
		</tr></logic:iterate>

	</table>
	<br />
	<table
		style="border-top: 2px solid black; align: right; text-align: right;">
		<tr>
			<th>Total avant remise</th>
			<td>${sessionScope.monPanierDto.totalAvantRemise}</td>
		</tr>
		<tr>
			<th>Remise</th>
			<td>${sessionScope.monPanierDto.remise}</td>
		</tr>
		<tr>
			<th>Total après remise</th>
			<td>${sessionScope.monPanierDto.totalApresRemise}</td>
		</tr>
	</table>
	<br />
	<div align="right">
		<button type="button" onclick="viderPanier">Vider</button>
		<button type="button" onclick="validerPanier">Valider</button>
	</div>
	<br /> <br />
</div>
