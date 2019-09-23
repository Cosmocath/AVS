<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_02.titre" /></title>
<div style="background-color: white; height: 100%; padding: 10px">
	<div>
		<h1>
			<bean:message key="USR_02.titre" />
		</h1>
		<div>
			<html:link href="listerUser.do?orderBy=${TRI}">
				<bean:message key="USR_02.bouton.trierListe" />
			</html:link>
		</div>
		<br />
		<table border="1">

			<tr align="center">
				<th><bean:message key="USR_02.mail" /></th>
				<th><bean:message key="USR_02.nom" /></th>
				<th><bean:message key="USR_02.prenom" /></th>
				<th><bean:message key="USR_02.dateNaissance" /></th>
				<th><bean:message key="USR_02.profil" /></th>
			</tr>

			<%-- parcours de la liste des users et affichage  de quelques données--%>
			<logic:iterate name="listeUser" id="utilisateur" scope="request">
				<tr>
					<td><bean:write name="utilisateur" property="mail" /></td>
					<td><bean:write name="utilisateur" property="nom" /></td>
					<td><bean:write name="utilisateur" property="prenom" /></td>
					<td><bean:write name="utilisateur" property="dateNaissance" /></td>
					<td><bean:write name="utilisateur" property="profil" /></td>

					<!-- Les lien sont bloqués en attendant les ecrans correspondant -->
					<td width="30%" align="center"><html:link href="#">
							<bean:message key="USR_02.editer" />
						</html:link></td>
					<td width="30%" align="center"><html:link href="#">
							<bean:message key="USR_02.consulter" />
						</html:link></td>
				</tr>
			</logic:iterate>
		</table>
		<br />
	</div>
</div>