<%@page import="presentation.panier.action.VoirValiderPanierAction"%>
<%@include file="/jsp/tiles/taglib.jsp"%>
<div style="background-color: white; height: 100%">

	<div>
		<h1>
			<bean:message key="PAN_00.Panier" />
		</h1>
		<html:form action="/validerPanier.do" focus="adresseLivraison">
			<table>
				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors property="error" />
				<tr>
					<td><bean:message key="PAN_01.Label.Adresse.Livraison" /></td>
					<td><html:textarea property="adresseLivraison"
							value="${adresse}"></html:textarea></td>
					<td><html:errors property="adresseLivraison"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>
				<tr>
					<td><bean:message key="PAN_01.Label.Adresse.Facturation" /></td>
					<td><html:textarea property="adresseFacturation"
							value="${adresse}"></html:textarea></td>
					<td><html:errors property="adresseFacturation"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>
				<tr>
					<td align="left"><html:reset property="submit" value="Reset" />
					</td>
					<td align="right"><html:submit property="submit"
							value="Valider" /></td>
				</tr>

			</table>
		</html:form>
	</div>
</div>