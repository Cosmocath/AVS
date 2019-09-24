<%@include file="/jsp/tiles/taglib.jsp"%>

<div style="background-color: #4B70D3FF; height: 100%">

	<html:link href="#" style="color: white; text-align: center; position: relative; left: 450px">CGV</html:link>
	<br />
	<html:link href="voirCGU.do" style="color: white; text-align: center; position: relative; left: 450px">CGU</html:link>


	<bean:define id="contextPath" value="<%=request.getContextPath()%>" />
	<html:link href="${contextPath}/changerLangue.do?langue=FR">
		<html:img src="img/flag_fr.svg" width="60px" height="45px" style="position: relative; left: 745px"></html:img>
	</html:link>

	<html:link href="${contextPath}/changerLangue.do?langue=EN">
		<html:img src="img/autocollant-drapeau-angleterre (2).jpg" width="60px" height="45px" style="position: relative; left: 750px"></html:img>
	</html:link>

</div>

