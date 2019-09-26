<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="USR_00.titre" /></title>

<div style="background-color: white; height: 100%">

	<div>
		<bean:message key="USR_00.titre" />
		<html:form action="/connecterUser.do" focus="mail">

			<table style="border: none;">
				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors property="error" />
				<tr>
					<td align="right"><bean:message key="USR_00.identifiant"></bean:message></td>
					<td align="left"><html:text property="mail" size="25"
							maxlength="25" altKey="USR_00.mail"></html:text></td>
					<td><html:errors property="mail" header="errors.global.header"
							footer="errors.global.footer" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="USR_00.password"></bean:message></td>
					<td align="left"><html:password property="password" size="25"
							maxlength="25"></html:password></td>
					<td><html:errors property="password"
							header="errors.global.header" footer="errors.global.footer" /></td>
				</tr>
				<tr>
					<td align="right"><html:submit property="submit"
							value="Se connecter" /></td>
				</tr>
			</table>
		</html:form>

		<%-- Permet d'afficher les messages si present --%>
		<logic:messagesPresent message="true">
			<html:messages id="connexionOK" property="connexionOK" message="true">
				<bean:write name="connexionOK" />
			</html:messages>
		</logic:messagesPresent>
	</div>
</div>