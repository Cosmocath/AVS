<%@page import="presentation.panier.action.VoirPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">


	<%-- JS nécessaire pour le bouton valider --%>
	<script type="text/javascript">
		function validerPanier() {
			document.location.href = "voirValiderPanier.do";

		}
	</script>

	<!-- 	<script type="text/javascript"> -->
	<!-- // 		function RedirectionJavascriptSupp() { -->
	<!-- // 			document.location.href = "supprimerPanier.do?id=" -->
	<!-- // 					+ document.getElementById("id").value; -->
	<!-- // 		} -->
	<!-- 	</script> -->
	<%-- 		<html:hidden  property="id" value="${produitDto.id}" styleId="id"/> --%>

	<%-- JS nécessaire pour le bouton vider --%>
	<script type="text/javascript">
		function viderPanier() {
			document.location.href = "viderPanier.do";

		}
	</script>

	<h1>
		<bean:message key="PAN_00.Panier" />
	</h1>

	<logic:equal name="monPanierDto" scope="session"
		property="quantiteTotale" value="0">
		<h3>
			<font color="red"> <bean:message key="PAN_00.panierVide" /></font>
		</h3>
	</logic:equal>

	<table style="width: 100%; text-align: center">
		<tr>
			<th><bean:message key="PAN_00.Designation" /></th>

			<th><bean:message key="PAN_00.Reference" /></th>
			<th><bean:message key="PAN_00.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Unitaire" /></th>
			<th><bean:message key="PAN_00.Modifier.Quantite" /></th>
			<th><bean:message key="PAN_00.Prix.Total" /></th>
			<th></th>
		</tr>
		<logic:iterate id="mapPanierQte" name="monPanierDto" scope="session"
			property="mapDesProduitsQte">
			<bean:define id="produitDto" name="mapPanierQte" property="key"></bean:define>
			<bean:define id="quantiteProduit" name="mapPanierQte"
				property="value"></bean:define>

			<tr>

				<td>${produitDto.designation}<br /> <html:img
						style="width:100px; height:100px;"
						src="${pageContext.request.contextPath}/afficherImage.do?urlImage=${produitDto.image}" /></td>
				<td>${produitDto.reference}</td>
				<td>${quantiteProduit.quantite}</td>
				<td>${produitDto.prix}<bean:message key="Global.euro" /></td>
				<td>
					<button type="button" onclick="augmenterQuantite">+</button>
					<button type="button" onclick="diminuerLaQuantite">-</button>

					<div style="float: right">
						<html:link
							href="ajouterPanier.do?id=${produitDto.id}&retour=panier">
							<bean:message key="PAN_00.bouton.ajouterPanier" />
						</html:link>
					</div> <br>
					<div style="float: right">
						<html:link
							href="diminuerQuantite.do?id=${produitDto.id}&retour=panier">
							<bean:message key="PAN_00.bouton.diminuerQuantite" />
						</html:link>
					</div>

				</td>
				<td>${quantiteProduit.prixParProduit}<bean:message
						key="Global.euro" /></td>
				<td>
					<button type="button" onclick="RedirectionJavascriptSupp()">
						<bean:message key="PAN_00.Supprimer" />
					</button>


					<div style="float: right">
						<html:link href="supprimerPanier.do?id=${produitDto.id}">
							<bean:message key="PAN_00.Supprimer" />
						</html:link>
					</div>

				</td>
			</tr>
		</logic:iterate>

	</table>
	<br />
	<table
		style="border-top: 2px solid black; align: right; text-align: right;">
		<tr>
			<th><bean:message key="PAN_00.Total.Avant.Remise" /></th>
			<td>${sessionScope.monPanierDto.totalAvantRemise}<bean:message
					key="Global.euro" /></td>
		</tr>
		<tr>
			<th><bean:message key="PAN_00.Remise" /></th>
			<td>${sessionScope.monPanierDto.remise}<bean:message
					key="Global.euro" /></td>
		</tr>
		<tr>
			<th><bean:message key="PAN_00.Total.Apres.Remise" /></th>
			<td>${sessionScope.monPanierDto.totalApresRemise}<bean:message
					key="Global.euro" /></td>
		</tr>
	</table>
	<br />
	<div align="right">
		<button type="button" onclick="viderPanier()">
			<bean:message key="PAN_00.Vider" />
		</button>
		<button type="button" onclick="validerPanier()">
			<bean:message key="PAN_00.Valider" />
		</button>
	</div>
	<br /> <br />
</div>
