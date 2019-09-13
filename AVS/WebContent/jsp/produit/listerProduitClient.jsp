<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%; padding: 10px">
	<h1>
		<bean:message key="PDT_00.listerProduits.titre" />
	</h1>
	<div style="float: right">
		<html:link href="listerProduitClient.do?orderBy=${TRI}">
			<bean:message key="PDT_00.bouton.trierListe" />
		</html:link>
	</div>

	<table>
		<logic:iterate name="listeProduits" id="produit" scope="request">
			<tr>
				<td>Mettre l'url de l'image ici</td>
				<td width="60%" style="padding-left: 100px"><bean:write
						name="produit" property="designation" /> /<bean:write
						name="produit" property="reference" /><br /> <bean:write
						name="produit" property="description" /><br /> <bean:write
						name="produit" property="prix" /> <bean:message key="Global.euro" />
					<bean:message key="PDT_00.produit.labelPrix" /></td>

				<td align="right"><html:button property="ajout" onclick="">
						<bean:message key="PDT_00.bouton.ajouterPanier" />
					</html:button></td>
			</tr>
		</logic:iterate>
	</table>
</div>
