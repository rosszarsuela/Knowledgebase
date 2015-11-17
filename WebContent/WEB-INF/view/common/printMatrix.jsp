<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
			<script type="text/javascript">
			function printButton()
			{
				/* document.getElementById('printButton').style.visibility="hidden"; */
				window.print();
			}
		</script>
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title><c:out value="${reportTitle}" /></title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/base.css"/>">
		<%-- <link rel="stylesheet" type="text/css" href="<c:url value="/css/layout_lyric.css"/>"> --%>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/js_style.css"/>">
	</head>
	<body>
		<div class="grid-bg" style="margin: 5px 5px 5px; min-height: inherit; float: left;">
			<div id="header" style="text-align: left"><c:out value="${reportTitle}" /></div>
			<div style="float: center; vertical-align: middle;">
				<a href="#" id="printButton" onClick="printButton()">
					<img src="<c:url value="/images/icon/printer.png"/>" height="20px" width="20px" title="Print">
				</a>
			</div>
			
			<table align="center" class="tablecat" style="color: white; width: 99%;">
				<tr>
					<c:forEach items="${columnNames}" var="name">
						<th>${name}</th>
					</c:forEach>
				</tr>
<%--			<c:choose>
					<c:when test="${page eq null}">--%>
						<c:forEach items="${matrix}" var="rowList"varStatus="index">
							<c:choose>
								<c:when test="${index.count%2 ne 0}">
									<tr class="oddrowcolor">
								</c:when>
								<c:otherwise>
									<tr class="evenrowcolor">
								</c:otherwise>
							</c:choose>
							<c:forEach items="${rowList}" var="row">
								<td>${row}</td>
							</c:forEach>
							</tr>
						</c:forEach>
<%--				</c:when>
					<c:otherwise>
						<c:forEach items="${page.content}">
						</c:forEach>
					</c:otherwise>
				</c:choose>--%>
			</table>
		</div>
	</body>
</html>