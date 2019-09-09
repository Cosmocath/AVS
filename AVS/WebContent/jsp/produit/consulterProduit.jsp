<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%; padding: 10px">
	<h1>
		<bean:write name="produit" property="designation" />
		/
		<bean:write name="produit" property="reference" />
	</h1>

	<%-- JS nécessaire pour le bouton supprimer --%>

	<script type="text/javascript">
		function RedirectionJavascript() {
			//     	 alert(document.getElementById("id").value);
			document.location.href = "listerProduitClient.do";
		}
	</script>

	<div style="float: right">
		<html:button property="delete" onclick="RedirectionJavascript()">
			<bean:message key="PDT_01.bouton.retour" />
		</html:button>
	</div>
	<br /> <br />
	<table>
		<tr>
			<td>Image</td>
			<td width="100%" style="padding-left: 80px"><bean:write
					name="produit" property="description" /><br /> <bean:write
					name="produit" property="prix" /> EURO <bean:message
					key="PDT_01.produit.labelPrix" /></td>

			<td align="right"><html:button property="ajout"
					onclick="RedirectionJavascript()">
					<bean:message key="PDT_01.bouton.ajouterPanier" />
				</html:button></td>
		</tr>
	</table>
</div>
