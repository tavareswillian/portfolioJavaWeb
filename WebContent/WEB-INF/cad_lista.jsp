<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script>
var salvar = new Array();

class Cadastro{
  constructor(nome,cpf, sexo, email, telefone, nascimento, cidade, estado ){
    this.nome = nome;
    this.cpf = cpf;
    this.sexo = sexo;
    this.email = email;
    this.telefone = telefone;
    this.nascimento = nascimento;
    this.cidade = cidade;
    this.estado = estado;
  }

  mensagem()
    {
    alert("Cadastro Efetuado!"+"\n"+"\n"+this.nome+"\n"+this.cpf+"\n"+this.sexo+"\n"+this.email+"\n"+this.telefone+"\n"+this.nascimento+"\n"+this.cidade+"\n"+this.estado);
    }

}


/* LISTAGEM DOS CADASTROS NA .HOME*/
function carregar(){
  var carrega = document.getElementById('load');
  var tamanho = salvar.length;
  var texto = "";
  if(tamanho !=0){
    texto="";
    for(i=0;i<tamanho;i++)
    {
     texto = texto+ '<li onclick="mostrar(' + salvar[i].cpf + ')">' + salvar[i].nome+"</li>";
     }
  } 				
  else{
    texto = "Nenhum cadastro até o momento";
  }

  carrega.innerHTML = texto;
}

function mostrar(cpf){
  alert(cpf);
}


/* LIMPAR AS INPUTS E SELECTS PARA PODER DIGITAR DE NUEVO */
function limpar(){
  document.querySelector('#nome').value= '';
  document.querySelector('#cpf').value= '';
  document.querySelector('#sexo').selectedIndex = 0;
  document.querySelector('#email').value= '';
  document.querySelector('#telefone').value= '';
  document.querySelector('#nascimento').selectedIndex = 0;
  document.querySelector('#cidade').value = '';
  document.querySelector('#estado').selectedIndex = 0;

}


/* SALVAR OS CADASTROS REALIZADOS*/
document.querySelector('#btnsalvar').onclick = function(evt){

  var nome = document.querySelector('#nome').value;
  var cpf = document.querySelector('#cpf').value;
  var sexo = document.querySelector('#sexo').value;
  var email = document.querySelector('#email').value;
  var telefone = document.querySelector('#telefone').value;
  var nascimento = document.querySelector('#nascimento').value;
  var cidade = document.querySelector('#cidade').value;
  var estado = document.querySelector('#estado').value;
  var usuario = new Cadastro(nome,cpf,sexo,email,telefone,nascimento,cidade,estado);
  salvar.push(usuario);
  usuario.mensagem();
  carregar();	

  limpar();

}


/* INFORMAÇÕES DO ICONE INFO */
document.querySelector('#info').onclick = function(evt){
  alert("Sistema desenvolvido pelos estudantes do Instituto Federal de Mato Grosso do Sul para as disciplinas de Linguagem de Apresentação e Estruturação de Conteúdos 2 e Programação Orientada a Objetos 2" + "\n" + "\n" + "By:" + "\n" + "William Medeiros" + "\n" + "Liliane Dauzacker");
}


/* FAZER A .HOME E A .CADASTRO SUMIR E APARECER*/
document.querySelector('.cadastro').style.display = 'none'

document.querySelector('#add').onclick = function(evt){
  document.querySelector('.cadastro').style.display = 'block'
  document.querySelector('.home').style.display = 'none'
}

document.querySelector('#voltar').onclick = function(evt){
  document.querySelector('.cadastro').style.display = 'none'
  document.querySelector('.home').style.display = 'block'
}


</script>
 <link href='https://fonts.googleapis.com/css?family=Open Sans' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="estilo.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<title>Listas</title>
</head>
<body onload="carregar()">
    <header>
        <div class="barra">
            <i class="material-icons mysize" id="info">info</i>
            <h1>Cadastro de Clientes</h1>
            <i class="material-icons mysize2" id="voltar">arrow_back</i>
        </div>
    </header>
        
    <main>
        <div class="home">  
            <form>
                <div class="input-container">
                  <div class="container-pesquisar">
                    <i class="material-icons" id="search">search</i>
                    <input id="pesquisar" type="text" placeholder="Para pesquisar digite o nome do Cliente"/>
                  </div>
                    <ul id="load">
                            <li></li>
                    </ul>
                </div>
            </form>
            <div class="float">
                    <a class="material-icons" id="add">add_circle</a>
            </div>
        </div>
           
        <id="container-cadastro" class="cadastro">
          <form>
                <div class="input-container2">
                    <label for="nome">Nome</label>
                    <input type="text" placeholder="Digite o nome do cliente" id="nome">
                </div>
                  
                <div class="input-container2">
                    <label for="cpf">CPF</label>
                    <input type="number" placeholder="Digite o CPF do cliente" id="cpf">
                </div>
                    
                <div class="input-container2">
                    <div class="styled-select">
                    <label for="sexo">Sexo</label>
                    <select name="" id="sexo" >
                        <option value="" disabled selected>Selecione o sexo</option>
                        <option value="femi">Feminino</option>
                        <option value="masc">Masculino</option>
                        <option value="mt">Outro</option>
                    </select>
                    </div>
                </div>
                    
                <div class="input-container2">
                    <label for="email">E-mail</label>
                    <input type="email" placeholder="Digite o e-mail do cliente" id="email">
                </div>

                <div class="input-container2">
                    <label for="telefone">Telefone</label>
                    <input type="phone" placeholder="Digite o Telefone do cliente" id="telefone">
                </div>
                  
                <div class="input-container2">
                    <label for="nascimento">Data de Nascimento</label>
                    <input type="date" placeholder="Digite a data de nascimento" id="nascimento">
                </div>

                <div class="input-container2">
                    <div class="styled-select">
                    <label for="estado">Estado</label>
                    <select name="" id="estado" >
                        <option value="" disabled selected>Selecione o estado</option>
                        <option value="ac">AC</option>
                        <option value="al">AL</option>
                        <option value="ap">AP</option>
                        <option value="am">AM</option>
                        <option value="ba">BA</option>
                        <option value="ce">CE</option>
                        <option value="df">DF</option>
                        <option value="es">ES</option>
                        <option value="go">GO</option>
                        <option value="ma">MA</option>
                        <option value="mt">MT</option>
                        <option value="ms">MS</option>
                        <option value="mg">MG</option>
                        <option value="pa">PA</option>
                        <option value="pb">PB</option>
                        <option value="pr">PR</option>
                        <option value="pe">PE</option>
                        <option value="pi">PI</option>
                        <option value="rj">RJ</option>
                        <option value="rn">RN</option>
                        <option value="rs">RS</option>
                        <option value="ro">RO</option>
                        <option value="rr">RR</option>
                        <option value="sc">SC</option>
                        <option value="sp">SP</option>
                        <option value="se">SE</option>
                        <option value="to">TO</option>
                    </select>
                    </div>
                </div>
          
                <div class="input-container2">
                    <label for="nome">Cidade</label>
                    <input type="text" placeholder="Digite o nome do cliente" id="cidade">
                </div>
          </form>
          
            <div class="button-container-button">
                <i class="btn-salvar" aria-hidden="true"></i>
                <input type="button" value="Salvar" id="btnsalvar">
                <i class="btn-remover" aria-hidden="true"></i>
                <input type="button" value="Remover" id="btnremover">
            </div>
              
        </div>
    </main>

<script type="text/javascript" src="javascript.js"></script>  

</body>
</html>