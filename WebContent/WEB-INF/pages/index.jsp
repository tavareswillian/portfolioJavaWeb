<!doctype html>
<html lang="us">
<head>
<meta charset="utf-8">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Portfólio</title>
<link href="js/jquery/jquery-ui.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<link href="estilo.css" rel="stylesheet" />
<script src="js/custom.js" charset="UTF-8"></script>
</head>
<body>
	<div class="topnav">
		<c:forEach items="${menuList}" var="menu" varStatus="status">
	       <%--  ${status.count}) ${item}<br/> --%>
	       <a class="${menu.status }" href="${menu.url }">${menu.titulo} </a>
	    </c:forEach>
		<a href="?acao=Sair" style="float: right;">Sair</a> 
		<span style="float: right; color: #ff8040"> ${mensagem} </span>
	</div>
	<h1>Portifólio</h1>

	<div class="ui-widget">
		<p>Apresentação da aplicação cliente de portfólio Java</p>
	</div>

	<jsp:include page="alerts/alert_basic.jsp" />
	<jsp:include page="alerts/alert_error.jsp" />
	<br>
	
	<!-- Tabs -->
	<h2 class="demoHeaders">Cadastros</h2>
	<div id="tabs" style="height: 300px">
		<ul>
			<c:forEach items="${optionList}" var="option">
					<li><a href="${option.url }">${option.title}
							<span class="${option.icon }" style="float: left; margin-right: .12em;"></span></a>
					</li>
			</c:forEach>
		</ul>	
		<c:forEach items="${menuBody}" var="menuItem">
			<jsp:include page="${menuItem}" />
		</c:forEach>
	</div>

	<script src="js/jquery/external/jquery/jquery.js"></script>
	<script src="js/jquery/jquery-ui.js"></script>
	<script src="js/items_interface.js"></script>
</body>
</html>
