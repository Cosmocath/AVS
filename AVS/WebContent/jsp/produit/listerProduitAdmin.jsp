<%@include file="/jsp/tiles/taglib.jsp"%>

<script type="text/javascript">
	function RedirectionJavascript() {
		document.location.href = "voirCreerProduit.do";
	}
</script>

<logic:messagesPresent message="true">
	<html:messages id="creationOK" property="creationOK" message="true"
		header="valid.global.header" footer="valid.global.footer">
		<bean:write name="creationOK" />
	</html:messages>
</logic:messagesPresent>

<div style="background-color: white; height: 100%">

	<h1>
		<bean:message key="PDT_04.listerProduits.titre" />
	</h1>

	<div style="width: 100%; text-align: right; margin-bottom: 30px">
		<html:button property="create" onclick="RedirectionJavascript()">
			<bean:message key="PDT_04.bouton.creer" />
		</html:button>
		<html:link href="listerProduitAdmin.do?orderBy=${TRI}">
			<bean:message key="PDT_04.bouton.trierListe" />
		</html:link>
	</div>

	<logic:iterate name="listeProduits" id="produit" scope="request">
		<div style="width: 100%; display: inline-block;">
			<div style="width: 20%; float: left">
				<html:link
					href="consulterProduit.do?id=${produit.id}&retour=produitAdmin">
					<html:img style="width:100px; height:100px;"
						src="${pageContext.request.contextPath}/afficherImage.do?urlImage=${produit.image}" />
				</html:link>
			</div>
			<div style="width: 60%; float: left;">
				<bean:write name="produit" property="designation" />
				/
				<bean:write name="produit" property="reference" />
			</div>
			<div style="width: 20%; float: right;">
				<html:button property="editer">
					<bean:message key="PDT_04.bouton.editer" />
				</html:button>
				<div>
					<bean:write name="produit" property="prix" />
					<bean:message key="Global.euro" />
					<bean:message key="PDT_04.produit.labelPrix" />
				</div>
			</div>

		</div>
		<div>
			<hr style="color: grey; width: 90%; padding: 0px">
		</div>

	</logic:iterate>

</div>