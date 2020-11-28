<!doctype html>
<html lang="us">
<head>
	<meta charset="utf-8">
	<title>Portfólio</title>
	<link href="js/jquery/jquery-ui.css" rel="stylesheet">
	<style>
	body{
		font-family: "Trebuchet MS", sans-serif;
		margin: 50px;
	}
	.demoHeaders {
		margin-top: 2em;
	}
	#dialog-link {
		padding: .4em 1em .4em 20px;
		text-decoration: none;
		position: relative;
	}
	#dialog-link span.ui-icon {
		margin: 0 5px 0 0;
		position: absolute;
		left: .2em;
		top: 50%;
		margin-top: -8px;
	}
	#icons {
		margin: 0;
		padding: 0;
	}
	#icons li {
		margin: 2px;
		position: relative;
		padding: 4px 0;
		cursor: pointer;
		float: left;
		list-style: none;
	}
	#icons span.ui-icon {
		float: left;
		margin: 0 4px;
	}
	.fakewindowcontain .ui-widget-overlay {
		position: absolute;
	}
	select {
		width: 200px;
	}
	</style>
<script>
function cadastra(tipoCadastro) {

	if(tipoCadastro === "lista") {
		cadastraLista();
	} else 	if(tipoCadastro === "usuario") {
		cadastraUsuario();
	}
  
}

function hide(idElem){
	var elemento = document.getElementById(idElem);
	  if (elemento.style.display === "block") {
			  elemento.style.display = "none";
		  }
}

function show(idElem){
	var elemento = document.getElementById(idElem);
	  if (elemento.style.display === "none") {
		  alerta.style.display = "block";
		  }
}

function cadastraLista(){
	var nmLista = document.getElementById("nmLista").value;
	  var dsLista = document.getElementById("dsLista").value;
	  var alerta = document.getElementById("alerta");
	  var erro = document.getElementById("erro");
	  var mensagemAlerta = document.getElementById("mensagemAlerta");
	  var mensagemErro = document.getElementById("mensagemErro");
	  erro.style.display = "none";
	  alerta.style.display = "none";
	  
	  if(nmLista === ""){
		  if (erro.style.display === "none") {
			  mensagemErro.innerText = "Nome da lista não informado!";
			  erro.style.display = "block";
			  } else {
				  erro.style.display = "none";
			  }
	  } else{
		  if (alerta.style.display === "none") {
			  mensagemAlerta.innerText = "Dados cadastrados!";
			  alerta.style.display = "block";
			  } else {
				  alerta.style.display = "none";
			  }
	  }
}

function cadastraUsuario(){
	  var nmUsuario = document.getElementById("nmUsuario").value;
	  var dsLogin = document.getElementById("dsLogin").value;
	  var dsSenha = document.getElementById("dsSenha").value;
	  var dsConfirmaSenha = document.getElementById("dsConfirmaSenha").value;
	  var alerta = document.getElementById("alerta");
	  var erro = document.getElementById("erro");
	  var mensagemAlerta = document.getElementById("mensagemAlerta");
	  var mensagemErro = document.getElementById("mensagemErro");
	  
	  if(dsSenha == null) {
		  mensagemErro.innerText = "Senha não digitada! É necessário fornecer uma senha...";
	  }
	  
	  if(dsSenha != dsConfirmaSenha){
		  mensagemErro.innerText = "As senhas digitadas não são iguais! Tente novamente...";
		  erro.style.display = "block";
	  }
	  
	 
	  erro.style.display = "none";
	  alerta.style.display = "none";
	  
	  if(nmUsuario === ""){
		  if (erro.style.display === "none") {
			  mensagemErro.innerText = "Nome de usuario não informado!";
			  erro.style.display = "block";
			  } else {
				  erro.style.display = "none";
			  }
	  } else{
		  if (alerta.style.display === "none") {
			  mensagemAlerta.innerText = "Usuário cadastrados!";
			  alerta.style.display = "block";
			  } else {
				  alerta.style.display = "none";
			  }
	  }
}

function limpar(tipoLimpeza){
	
	if(tipoLimpeza === 'cadastroLista'){
		document.getElementById("nmLista").value = "";
		document.getElementById("dsLista").value = "";
	}
}
</script>
</head>
<body>

<h1>Portifólio</h1>

<div class="ui-widget">
	<p>Apresentação da aplicação cliente de portfólio Java</p>
</div>

<div class="ui-widget" id="alerta" hidden="hidden" onclick="hide('alerta');">
		<a href="#" title="Clique para fechar esta mensagem" style="text-decoration: none;">
			<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-info"
						style="float: left; margin-right: .3em;"></span> <strong>Sucesso:</strong>
					<span id="mensagemAlerta"></span>
				</p>
			</div>
		</a>
	</div>
	<div class="ui-widget" id="erro" hidden="hidden"
		onclick="hide('erro');">
		<a href="#" title="Clique para fechar esta mensagem" style="text-decoration: none;">
			<div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
				<p>
					<span class="ui-icon ui-icon-alert"	style="float: left; margin-right: .3em;"></span> <strong>Atenção:
					</strong> <span id="mensagemErro"></span>
				</p>
			</div>
		</a>
	</div>
	<br>
<!-- <div class="ui-widget" hidden="hidden">
	<div class="ui-state-default ui-corner-all" style="padding: 0 .7em;">
		<p><span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em;"></span>
		<strong>Alert:</strong><span id="novo"></span></p>
	</div>
</div> -->
<!-- Tabs -->
<h2 class="demoHeaders">Cadastros</h2>
<div id="tabs" style="height:300px">
	<ul>
		<li><a href="#usuarios">Usuários<span class="ui-icon ui-icon-person" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#listas">Listas<span class="ui-icon ui-icon-note" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#funcionalidades">Funcionalidades<span class="ui-icon ui-icon-wrench" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#documentos">Documentos<span class="ui-icon ui-icon-document" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#duvidas">Dúvidas<span class="ui-icon ui-icon-help" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#eventos">Eventos<span class="ui-icon ui-icon-calendar" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#perfis">Perfis<span class="ui-icon ui-icon-contact" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#permissoes">Permissões<span class="ui-icon ui-icon-locked" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#politicas">Políticas<span class="ui-icon ui-icon-suitcase" style="float: left; margin-right: .12em;"></span></a></li>
		<li><a href="#repositorios">Repositórios<span class="ui-icon ui-icon-folder-open" style="float: left; margin-right: .12em;"></span></a></li>
		
	</ul>
	<%@include file="cadastros/cadastro_usuario.jsp" %>
	<%@include file="cadastros/cadastro_lista.jsp" %>
	<div id="funcionalidades">Cadastro de funcionalidades.</div>
	<div id="documentos">Cadastro de documentos.</div>
	<div id="duvidas">Cadastro de dúvidas.</div>
	<div id="eventos">Cadastro de eventos.</div>
	<div id="perfis">Cadastro de perfis.</div>
	<div id="permissoes">Cadastro de permissões.</div>
	<div id="politicas">Cadastro de políticas.</div>
	<div id="repositorios">Cadastro de repositórios.</div>
</div>

<script src="js/jquery/external/jquery/jquery.js"></script>
<script src="js/jquery/jquery-ui.js"></script>
<script>
$( "#accordion" ).accordion();

var availableTags = [
	"ActionScript",
	"AppleScript",
	"Asp",
	"BASIC",
	"C",
	"C++",
	"Clojure",
	"COBOL",
	"ColdFusion",
	"Erlang",
	"Fortran",
	"Groovy",
	"Haskell",
	"Java",
	"JavaScript",
	"Lisp",
	"Perl",
	"PHP",
	"Python",
	"Ruby",
	"Scala",
	"Scheme"
];
$( "#autocomplete" ).autocomplete({
	source: availableTags
});

$( "#button" ).button();
$( "#button-icon" ).button({
	icon: "ui-icon-gear",
	showLabel: false
});

$( "#radioset" ).buttonset();

$( "#controlgroup" ).controlgroup();

$( "#tabs" ).tabs();

$( "#dialog" ).dialog({
	autoOpen: false,
	width: 400,
	buttons: [
		{
			text: "Ok",
			click: function() {
				$( this ).dialog( "close" );
			}
		},
		{
			text: "Cancel",
			click: function() {
				$( this ).dialog( "close" );
			}
		}
	]
});

// Link to open the dialog
$( "#dialog-link" ).click(function( event ) {
	$( "#dialog" ).dialog( "open" );
	event.preventDefault();
});

$( "#datepicker" ).datepicker({
	inline: true
});

$( "#slider" ).slider({
	range: true,
	values: [ 17, 67 ]
});

$( "#progressbar" ).progressbar({
	value: 20
});

$( "#spinner" ).spinner();

$( "#menu" ).menu();

$( "#tooltip" ).tooltip();

$( "#selectmenu" ).selectmenu();

// Hover states on the static widgets
$( "#dialog-link, #icons li" ).hover(
	function() {
		$( this ).addClass( "ui-state-hover" );
	},
	function() {
		$( this ).removeClass( "ui-state-hover" );
	}
);
</script>
</body>
</html>
