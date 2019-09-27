<%@include file="/jsp/tiles/taglib.jsp"%>

<div
	style="background-color: #FFFFFF; height: 100%; padding-bottom: 25px;">

	<html:link href="#"
		style="color: black; text-align: center; position: relative; left: 450px">CGV</html:link>
	<br />
	<html:link href="voirCGU.do"
		style="color: black; text-align: center; position: relative; left: 450px">CGU</html:link>


	<bean:define id="contextPath" value="<%=request.getContextPath()%>" />
	<html:link href="${contextPath}/changerLangue.do?langue=FR">
		<html:img src="img/flag_fr.svg" width="60px" height="45px"
			style="position: relative; left: 745px"></html:img>
	</html:link>

	<html:link href="${contextPath}/changerLangue.do?langue=EN">
		<html:img src="img/autocollant-drapeau-angleterre (2).jpg"
			width="60px" height="45px" style="position: relative; left: 750px"></html:img>
	</html:link>

</div>

