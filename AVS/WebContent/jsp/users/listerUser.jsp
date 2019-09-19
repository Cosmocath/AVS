<%@include file="/jsp/tiles/taglib.jsp"%>


<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><bean:message key="USR_02.titre" /></title>
</head>
<body>
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

				<td width="30%" align="center"><html:link
						href="voirEditerChat.do?id=${user.id}">
						<bean:message key="USR_02.editer" />
					</html:link></td>
				<td width="30%" align="center"><html:link
						href="consulterUser.do?id=${user.id}">
						<bean:message key="USR_02.consulter" />
					</html:link></td>
			</tr>
		</logic:iterate>
	</table>
	<br />

</body>
</html:html>
