<%@include file="/jsp/tiles/taglib.jsp"%>
<div style="background-color: #D65858; height: 100%; padding: 10px">
	<p></p>
	<br />
	<br />
</div>

//TODO a revoir 
<title>Commande</title>
<body>
	<logic:iterate name="listeCommande" id="commande" scope="request">
	
		<div>
			<html:link href="consulterCommande.do?id=${commande.id_Commande}">
				<bean:write name="commande" property="numero_Commande" />				
			</html:link>
			<br />
			<bean:write name="commande" property="date" />
		</div>
	</logic:iterate>
