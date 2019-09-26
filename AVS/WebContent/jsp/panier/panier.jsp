<%@page import="presentation.panier.action.VoirPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">


	<%-- JS nécessaire pour le bouton valider --%>
	<script type="text/javascript">
		function validerPanier() {
			document.location.href = "voirValiderPanier.do";

		}
	</script>

	<h1>
		<bean:message key="PAN_00.Panier" />
	</h1>

	<logic:messagesPresent message="true">
		<html:messages id="panierVide" message="true" header="myForm.header"
			footer="myForm.footer">
			<bean:write name="panierVide" />
		</html:messages>
	</logic:messagesPresent>

	<table style="width: 100%; text-align: center">
		<tr>
			<th><bean:message key="PAN_00.Designation" /></th>
			<th><bean:message key="PAN_00.Reference" /></th>
			<th><bean:message key="PAN_00.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Unitaire" /></th>
			<th><bean:message key="PAN_00.Modifier.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Total" /></th>
		</tr>
		<logic:iterate id="mapPanierQte" name="monPanierDto" scope="session"
			property="mapDesProduitsQte">
			<bean:define id="produitDto" name="mapPanierQte" property="key"></bean:define>
			<bean:define id="quantiteProduit" name="mapPanierQte"
				property="value"></bean:define>

			<tr>
				<td>${produitDto.designation}</td>
				<td>${produitDto.reference}</td>
				<td>${quantiteProduit.quantite}</td>
				<td>${produitDto.prix}<bean:message key="Global.euro" /></td>
				<td>
					<button type="button" onclick="RedirectionJavascript()">+</button>
					<button type="button" onclick="diminuerQuantite">-</button>

					<div style="float: right">
						<html:link
							href="ajouterPanier.do?id=${produitDto.id}&retour=panier">
							<bean:message key="PAN_00.bouton.ajouterPanier" />
						</html:link>
					</div>
				</td>
				<td>${quantiteProduit.prixParProduit}<bean:message
						key="Global.euro" /></td>
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
			<td>${sessionScope.monPanierDto.totalAvantRemise}<bean:message
					key="Global.euro" /></td>
		</tr>
		<tr>
			<th>Remise</th>
			<td>${sessionScope.monPanierDto.remise}<bean:message
					key="Global.euro" /></td>
		</tr>
		<tr>
			<th>Total après remise</th>
			<td>${sessionScope.monPanierDto.totalApresRemise}<bean:message
					key="Global.euro" /></td>
		</tr>
	</table>
	<br />
	<div align="right">
		<button type="button" onclick="viderPanier">
			<bean:message key="PAN_00.Vider" />
		</button>
		<button type="button" onclick="validerPanier()">
			<bean:message key="PAN_00.Valider" />
		</button>
	</div>
	<br /> <br />
</div>
