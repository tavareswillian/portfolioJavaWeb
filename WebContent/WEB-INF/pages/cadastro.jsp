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
<c:forEach items="${menuBody}" var="menuItem">
		<jsp:include page="${menuItem}" />
</c:forEach>
<%-- 
<%@include file="cadastros/cadastro_usuario.jsp" %>
<%@include file="cadastros/cadastro_lista.jsp" %>
<%@include file="cadastros/cadastro_funcionalidade.jsp" %>
<%@include file="cadastros/cadastro_documento.jsp" %>
<%@include file="cadastros/cadastro_duvida.jsp" %>
<%@include file="cadastros/cadastro_evento.jsp" %>
<%@include file="cadastros/cadastro_perfil.jsp" %>
<%@include file="cadastros/cadastro_permissao.jsp" %>
<%@include file="cadastros/cadastro_politica.jsp" %>
<%@include file="cadastros/cadastro_repositorio.jsp" %> 
--%>
</body>
</html>