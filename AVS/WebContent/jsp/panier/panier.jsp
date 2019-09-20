<%@page import="presentation.panier.action.VoirPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div
	style="background-color: white; height: auto; width: auto; border: 2px solid black; text-align: left; margin-top: 100px; align: center;">
	<h1 style="background: white; margin-top: -30px;">Panier</h1>
	<table class="tab1">
		<tr style="border-bottom: 2px solid black;">
			<th>Designation</th><!-- produitDto -->
			<th>Référence</th><!-- produitDto -->
			<th>Quantite</th>
			<th>Prix unitaire</th>
			<th></th>
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
				<td>&nbsp;&nbsp;
					<button type="button" onclick="ajouterQuantite">+</button>&nbsp;&nbsp;
					<button type="button" onclick="diminuerQuantite">-</button>&nbsp;&nbsp;
				</td>
				<td>${quantiteProduit*produitDto.prix}</td>
				<td>&nbsp;&nbsp;
					<button type="button" onclick="supprimerProduit">Supprimer</button>
				</td>
		</tr></logic:iterate>

	</table>
	<br />
	<table
		style="margin-left: left; border-top: 2px solid black; align: right; text-align: right;">
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
		&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="validerPanier">Valider</button>
		&nbsp;&nbsp;&nbsp;&nbsp;
	</div>
	<br /> <br />
</div>
