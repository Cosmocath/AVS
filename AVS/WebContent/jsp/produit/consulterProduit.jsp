<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%; padding: 10px">
	<h1>
		<bean:message key="PDT_01.designation.reference" />
	</h1>
	<table>
		<logic:iterate name="consulterProduits" id="produit" scope="request">
			<tr>
				<td width="60%" style="padding-left: 100px"><bean:write
						name="produit" property="designation" /> /<bean:write
						name="produit" property="reference" /><br /> <bean:write
						name="produit" /></td>
				<td>Mettre l'url de l'image ici</td>
				<td width="60%" style="padding-left: 100px"><bean:write
						name="produit" property="description" /><br /> <bean:write
						name="produit" property="prix" /> EURO <bean:message
						key="PDT_01.produit.labelPrix" /></td>

				<td align="right"><html:button property="ajout"
						onclick="RedirectionJavascript()">
						<bean:message key="PDT_01.bouton.ajouterPanier" />
					</html:button></td>
			</tr>
		</logic:iterate>
	</table>
</div>
