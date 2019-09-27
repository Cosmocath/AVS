<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">
	<h1>
		<bean:message key="PDT_03.titre" />
	</h1>

	<html:form action="/editerProduit.do" focus="designation">

		<html:hidden property="idProduit" />
		<table>

			<tr>
				<td align="right"><bean:message key="PDT_03.designation" /></td>
				<td align="left"><html:text property="designation" size="25"
						maxlength="25" /></td>
				<td><html:errors property="designation"
						header="errors.field.header" footer="errors.field.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_03.reference" /></td>
				<td align="left"><html:text property="reference" size="25"
						maxlength="25" /></td>
				<td><html:errors property="reference"
						header="errors.field.header" footer="errors.field.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_03.description" /></td>
				<td align="left"><html:textarea property="description" /></td>
				<td><html:errors property="description"
						header="errors.field.header" footer="errors.field.footer" /></td>
			</tr>
			<tr>

				<td align="right"><bean:message key="PDT_03.prix" /></td>
				<td align="left"><html:text property="prix" size="25"
						maxlength="25" /></td>
				<td><html:errors property="prix" header="errors.field.header"
						footer="errors.field.footer" /></td>
			</tr>
			<tr>
				<td><html:submit property="submit">
						<bean:message key="PDT_03.submit" />
					</html:submit></td>
				<td><html:reset /></td>
				<td><html:submit property="delete">
						<bean:message key="PDT_03.delete" />
					</html:submit></td>
			</tr>
		</table>
	</html:form>

	<div style="float: left">
		<html:link href="http://localhost:8080/AVS/listerProduitAdmin.do">
			<bean:message key="PDT_01.bouton.retour" />
		</html:link>
	</div>
	<br>
	<logic:messagesPresent message="true">
		<html:messages id="updateProduitOK" property="updateProduitOK"
			message="true" header="valid.global.header"
			footer="valid.global.footer">
			<bean:write name="updateProduitOK" />
		</html:messages>
	</logic:messagesPresent>

	<%-- permet d'afficher les erreurs "globales" --%>
	<html:errors header="errors.global.header" property="error" />
</div>
