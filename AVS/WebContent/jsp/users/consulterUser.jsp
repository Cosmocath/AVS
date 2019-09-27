<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_03.titre" /></title>
<div style="height: 100%">
	<div>
		<h1>
			<bean:message key="USR_03.titre" />
		</h1>
		<div>
			<br />
			<bean:message key="USR_03.nom" />${user.nom}
			<br />
			<bean:message key="USR_03.prenom" />${user.prenom}
			<br />
			<bean:message key="USR_03.date_naissance" />${user.dateNaissance}
			<br />
			<bean:message key="USR_03.adresse" />${user.adresse}
			<br />
			<bean:message key="USR_03.mail" />${user.mail}
			<br />
			<bean:message key="USR_03.profil" />${user.profilDto.nom}

			<div>
				<br />
				<html:link href="listerUser.do">
					<bean:message key="USR_03.retour" />
				</html:link>

				<html:link href="voirEditerUser.do?id=${user.id}">
					<bean:message key="USR_03.editer" />
				</html:link>

				<html:link href="listerCommande.do?id=${user.id}">
					<bean:message key="USR_03.listeDesCommandes" />
				</html:link>
			</div>
		</div>
	</div>
</div>