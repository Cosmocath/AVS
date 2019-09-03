<%@include file="/jsp/tiles/taglib.jsp" %>
<body>
<div style="background-color: green; height: 100%; padding: 10px">
	<%
	    //TODO à titre d'exemple, à supprimer avec son folder
	%>
	<h1>HELLOWORLD!</h1>
	<bean:message key="test.helloworld1" />
	<br />
	
	<bean:message key="test.helloworld2" />

	<a href="<%=request.getContextPath()%>/changerLangue.do?langue=fr"><html:img src="img/flag_fr.svg" width="60px"></html:img></a>
	<a href="<%=request.getContextPath()%>/changerLangue.do?langue=en"><html:img src="img/flag_en.svg" width="60px"></html:img></a>
</div>
</body>


