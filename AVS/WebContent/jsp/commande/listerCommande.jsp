<%@include file="/jsp/tiles/taglib.jsp"%>
<!-- style css -->
<style>
.prix_titre {
	text-align: center;
}

.prix {
	text-align: center;
}
</style>
<div style="background-color: white; height: 100%">
	<table style="width: 100%">
		<tr class="commande">
			<th><bean:message key="CDE_00.Commande.titre" /></th>
			<th><bean:message key="CDE_00.Prix.titre" /></th>
		</tr>
		<logic:iterate name="listeCommande" id="commande" scope="request">
			<tr class="prix_titre">
				<td><html:link
						href="consulterCommande.do?id=${commande.idCommande}">
						<bean:message key="CDE_00.N°Commande" />
						<bean:write name="commande" property="numeroCommande" />
					</html:link> <br /> <bean:message key="CDE_00.Date" /> : <bean:write
						name="commande" property="date" /></td>
				<td>
					<div class="prix">
						<bean:message key="CDE_00.Prix" />
						:
						<bean:write name="commande" property="montantAvecRemise" />
						<bean:message key="Global.euro" />
					</div>
				</td>

			</tr>
		</logic:iterate>
	</table>
</div>