<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: white; height: 100%">
	<h1>
		<bean:message key="PDT_02.titre" />
	</h1>
	<%-- Permet d'afficher les messages si present --%>
	<logic:messagesPresent message="true">
		<html:messages id="creationProduitOK" property="creationProduitOK"
			message="true" header="valid.global.header"
			footer="valid.global.footer">
			<bean:write name="creationProduitOK" />
		</html:messages>
	</logic:messagesPresent>
	<%-- permet d'afficher les erreurs "globales" --%>
	<html:errors header="errors.global.header"
		footer="errors.global.footer" property="error" />
	<br />

	<html:form action="/creerProduit.do" focus="designation"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td align="right"><bean:message key="PDT_02.designation" /></td>
				<td align="left"><html:text property="designation" size="25"
						maxlength="25" /></td>
				<td><html:errors property="designation"
						header="errors.global.header" footer="errors.global.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_02.reference" /></td>
				<td align="left"><html:text property="reference" size="25"
						maxlength="25" /></td>
				<td><html:errors property="reference"
						header="errors.global.header" footer="errors.global.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_02.description" /></td>
				<td align="left"><html:textarea property="description" /></td>
				<td><html:errors property="description"
						header="errors.global.header" footer="errors.global.footer" /></td>
			</tr>
			<tr>

				<td align="right"><bean:message key="PDT_02.prix" /></td>
				<td align="left"><html:text property="prix" size="25"
						maxlength="25" /></td>
				<td><html:errors property="prix" header="errors.global.header"
						footer="errors.global.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_02.image" /></td>
				<td align="left"><html:file property="image" /></td>
				<td><html:errors property="image" header="errors.field.header"
						footer="errors.field.footer" /></td>
			</tr>
			<tr>
				<td align="right"><bean:message key="PDT_02.actif" /></td>
				<td align="left"><html:checkbox property="actif" value="true" /></td>
				<td><html:errors property="actif" header="errors.field.header"
						footer="errors.field.footer" /></td>
			</tr>
			<tr>
				<td align="right"><html:submit property="submit">
						<bean:message key="PDT_02.submit" />
					</html:submit></td>
				<td align="left"><html:reset /></td>
				<td></td>
			</tr>
		</table>
	</html:form>

	<br />
</div>
