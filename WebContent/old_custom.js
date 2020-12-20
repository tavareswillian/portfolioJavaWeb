function cadastrar(tipoCadastro) {

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