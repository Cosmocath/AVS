<%@include file="/jsp/tiles/taglib.jsp"%>
<div style="background-color: green; height: 100%; padding: 10px">
	<%
	    //TODO à titre d'exemple, à supprimer avec son folder
	%>
	<h1>HELLOWORLD!</h1>
	<bean:message key="test.helloworld1" />
	<br />

	<bean:message key="test.helloworld2" />

	<bean:define id="contextPath" value="<%=request.getContextPath()%>" />
	<html:link href="${contextPath}/changerLangue.do?langue=FR">
		<html:img src="img/flag_fr.svg" width="60px"></html:img>
	</html:link>
	<html:link href="${contextPath}/changerLangue.do?langue=EN">
		<html:img src="img/flag_en.svg" width="60px"></html:img>
	</html:link>
</div>


