<%@page import="presentation.panier.action.VoirPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">
	<h1>
		<bean:message key="PAN_00.Panier" />
	</h1>
	<table style="width: 100%; text-align: center">
		<tr>
			<th><bean:message key="PAN_00.Designation" /></th>
			<th><bean:message key="PAN_00.Reference" /></th>
			<th><bean:message key="PAN_00.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Unitaire" /></th>
			<th><bean:message key="PAN_00.Modifier.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Total" /></th>
		</tr>
		<logic:iterate name="monPanierDto" id="mapPanierQte" scope="session"
			property="mapDesProduitsQte">
			<bean:define name="mapPanierQte" id="produitDto" property="key"></bean:define>
			<bean:define name="mapPanierQte" id="quantiteProduit"
				property="value"></bean:define>

			<tr>
				<td>${produitDto.designation}</td>
				<td>${produitDto.reference}</td>
				<td>${quantiteProduit}</td>
				<td><bean:write name="produitDto" property="prix" /> <bean:message
						key="Global.euro" /></td>
				<td>
					<button type="button" onclick="ajouterQuantite">+</button>
					<button type="button" onclick="diminuerQuantite">-</button>
				</td>
				<td>Prix à calculer !</td>
				<td>
					<button type="button" onclick="supprimerProduit">
						<bean:message key="PAN_00.Supprimer" />
					</button>
				</td>
			</tr>
		</logic:iterate>

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
		<button type="button" onclick="viderPanier">
			<bean:message key="PAN_00.Vider" />
		</button>
		<button type="button" onclick="validerPanier">
			<bean:message key="PAN_00.Valider" />
		</button>
	</div>
	<br /> <br />
</div>
