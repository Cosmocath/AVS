<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">
	<h1>
		<bean:write name="produit" property="designation" />
		/
		<bean:write name="produit" property="reference" />
	</h1>

	<div style="float: right">
		<html:link href="${urlRetour}">
			<bean:message key="PDT_01.bouton.retour" />
		</html:link>
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