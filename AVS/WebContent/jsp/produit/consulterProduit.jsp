<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">
	<h1>
		<bean:write name="produit" property="designation" />
		/
		<bean:write name="produit" property="reference" />
	</h1>

	<%-- 	<%-- JS nécessaire pour le bouton supprimer --%>

	<!-- 	<script type="text/javascript"> -->
	<!-- // 		function RedirectionJavascript() { -->
	<!-- // 			document.location.href = "ajouterPanier.do?id=" -->
	<!-- // 					+ document.getElementById("id").value -->
	<!-- // 			"&retour=consulterProduit"; -->
	<!-- // 		} -->
	<!-- 	</script> -->

	<script type="text/javascript">
		function ajouterPanier(id) {
			var lien = "ajouterPanier.do?id= + id + "&retour=consulterProduit";
			document.location.href = lien;
		}
	</script>

	<div style="float: right">
		<html:link href="${urlRetour}">
			<bean:message key="PDT_01.bouton.retour" />
		</html:link>
	</div>

	<br /> <br />
	<table>
		<tr>
			<td><html:img style="width:100px; height:100px;"
					src="${pageContext.request.contextPath}/afficherImage.do?urlImage=${produit.image}" /></td>
			<td width="80%" style="padding-left: 80px"><bean:write
					name="produit" property="description" /><br /> <bean:write
					name="produit" property="prix" /> <bean:message key="Global.euro" />
				<bean:message key="PDT_01.produit.labelPrix" /></td>

			<td><html:button property="add"
					onclick="ajouterPanier(${produit.id})">
					<bean:message key="PDT_01.bouton.ajouterPanier" />
				</html:button></td>


			<%-- 			<td align="right"><html:button property="ajout" --%>
			<%-- 					onclick="RedirectionJavascript()"> --%>
			<%-- 					<bean:message key="PDT_01.bouton.ajouterPanier" /> --%>
			<%-- 				</html:button></td> --%>
			<!-- 		</tr> -->
	</table>
</div>