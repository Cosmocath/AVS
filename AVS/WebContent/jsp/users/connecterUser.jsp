<%@include file="/jsp/tiles/taglib.jsp"%>
<title><bean:message key="connecterUser.titre" /></title>

<div style="height: 100%; padding: 10px">
	<div>
		<bean:message key="connecterUser.titre" />
		<html:form action="/connecterUser.do" focus="mail">

			<table style="border: none;">
				<%-- permet d'afficher les erreurs "globales" --%>
				<html:errors property="error" />
				<tr>
					<td align="right"><bean:message
							key="connecterUser.identifiant"></bean:message></td>
					<td align="left"><html:text property="mail" size="25"
							maxlength="25" altKey="connecterUser.mail"></html:text></td>
					<td><html:errors property="mail" /></td>
				</tr>

				<tr>
					<td align="right"><bean:message key="connecterUser.password"></bean:message></td>
					<td align="left"><html:text property="password" size="25"
							maxlength="25"></html:text></td>
					<td><html:errors property="password" /></td>
				</tr>
				<tr>
					<td align="right"><html:submit property="submit"
							value="Se connecter" /></td>
				</tr>
				<tr></tr>
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