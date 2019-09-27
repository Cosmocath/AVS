<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_04.titre" /></title>

<div style="height: 100%;">
	<div>
		<h1>
			<bean:message key="USR_04.titre" />
		</h1>

		<html:form action="/editerUser.do" focus="mail">

			<%-- ne pas perdre l'id du chat à modifier, on le soumet en tant que champ caché du form --%>
			<html:hidden property="id" styleId="id" />
			<html:hidden property="password" />

			<table style="border: none;">

				<tr>
					<td align="right"><bean:message key="USR_04.mail" /></td>
					<td align="left"><html:text property="mail" size="25"
							maxlength="25" readonly="true" /></td>
					<td><html:errors property="mail"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_04.nom" /></td>
					<td align="left"><html:text property="nom" size="25"
							maxlength="25" /></td>
					<td><html:errors property="nom"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.prenom" /></td>
					<td align="left"><html:text property="prenom" size="25"
							maxlength="25" /></td>
					<td><html:errors property="prenom"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.date.naissance" /></td>
					<td align="left"><html:text property="dateNaissance" size="25"
							maxlength="25" /></td>
					<td><html:errors property="dateNaissance"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.password" /></td>
					<td align="left"><html:password property="newpassword"
							size="25" maxlength="25" /></td>
					<td><html:errors property="newpassword"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.confirm.password" /></td>
					<td align="left"><html:password property="confirmpassword"
							size="25" maxlength="25" /></td>
					<td><html:errors property="confirmpassword"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.adresse" /></td>
					<td align="left"><html:text property="adresse" size="25"
							maxlength="25" /></td>
					<td><html:errors property="adresse"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>
				<tr>
					<td align="right"><bean:message key="USR_04.profil" /></td>
					<td align="left"><html:radio property="profil" value="2">
							<bean:message key="USR_04.profil.client" />
						</html:radio> <html:radio property="profil" value="3"></html:radio> <bean:message
							key="USR_04.profil.admin" /></td>
					<td><html:errors property="profil"
							header="USR_04.errors.global.header"
							footer="USR_04.errors.field.footer" /></td>
				</tr>

				<tr>
					<td align="right"><html:submit property="submit"
							value="Submit" /></td>
					<td align="left"><html:reset /></td>
				</tr>

				<%-- Permet d'afficher les messages si present --%>
				<logic:messagesPresent message="true">
					<html:messages id="updateOK" property="updateOK" message="true"
						header="USR_04.valid.global.header"
						footer="USR_04.valid.global.footer">
						<bean:write name="updateOK" />
					</html:messages>
				</logic:messagesPresent>

				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors header="USR_04.errors.global.header" property="error" />


			</table>
			<html:link href="listerUser.do">
				<bean:message key="USR_04.editer.retour" />
			</html:link>
			<html:link href="#">
				<bean:message key="USR_04.supprimer" />
			</html:link>

		</html:form>
	</div>
</div>