<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="js/lista.js"></script>
<script>

function formToJSON() {
    var result = {
        "id" : $('#listaId').val(),
        "name" : $('#txtName').val(),
        "descricao" : $('#dsLista').val()
    };

    $("#dsLista span").each(function(index, elem) {

        result.phones.push({
            "type" : $("#dsLista #" + elem.id + " input:eq(0)").val(),
            "number" : $("#dsLista #" + elem.id + " input:eq(1)").val()
        });

    });

/*     $("#emails span").each(function(index, elem) {

        result.emails.push({
            "type" : $("#emails #" + elem.id + " input:eq(0)").val(),
            "address" : $("#emails #" + elem.id + " input:eq(1)").val()
        });

    }); */

    return (JSON.stringify(result));
}

function loadlista(id) {
    findById(id, function(data) {
        fillForm(data);
        $("#form").css({
            "visibility" : "visible",
            "display" : "block"
        });
        $("#fieldset").html(" Editando Contato ");
    });
}

function clearForm() {
    $("#fieldset").html("");
    fillForm({
        "name" : ""
    });
}

function fillForm(lista) {

    $("#listaId").val(lista.idLista);

    $("#txtName").val(lista.nmLista);

    $("#dsLista").html("");
    if (lista.dsLista != null) {
        for ( var i = 0; i < lista.dsLista.length; i++) {
            addInput("#dsLista", lista.dsLista[i].type,
                    lista.dsLista[i].number);
        }
    }
}

function addInput(root, type, value) {
    var index = $(root).children().length;
    var html = "<span id='item" + index + "' ><input type='text' value='"
            + type + "'>";
    html += "<input type='text' value='" + value + "'>";
    html += "<input type='button' value='-' onclick='$(\"" + root + " #item"
            + index + "\").remove()'><br/></span>";

    inputs = $(root).append(html);
}


function saveOrUpdate() {
    if ($("#listaId").val() != null && $("#listaId").val() != "") {
        updatelista($('#listaId').val(), formToJSON(), function(data, textStatus, jqXHR) {
            alert('Contato atualizado com sucesso!');
            clearForm();
            $("#form").css({
                "visibility" : "hidden",
                "display" : "none"
            });
            findAll();
        });
    } else {
        addlista(formToJSON(), function(data, textStatus, jqXHR) {
            alert('Contato criado com sucesso!');
            clearForm();
            $("#form").css({
                "visibility" : "hidden",
                "display" : "none"
            });
            findAll(renderList);
        });
    }
}

function newlista() {
    clearForm();
    $("#form").css({
        "visibility" : "visible",
        "display" : "block"
    });
    $("#fieldset").html(" Novo Contato ");
}

function search() {
    findById($("#searchName").val(), renderList);
}

function removelista(id) {
    deletelista(id, function(data, textStatus, jqXHR) {
        alert('Contato removido com sucesso!');
        findAll(renderList);
    });
}

function cancel() {

    $("#form").css({
        "visibility" : "hidden",
        "display" : "none"
    });
    clearForm();
}

function renderList(data) {

    var html = "";

    html += "<ul>";

    for ( var i = 0; i < data.length; i++) {
        var lista = data[i];

        /* alert('Registro: ' + lista.idLista); */
        
        html += "<li><strong><a href='#' onclick='loadlista("
                + lista.idLista + ")'>#" + lista.idLista + " - " + lista.nmLista
                + "</a></strong>";

        if (lista.dsLista != null && lista.dsLista.length > 0) {
            html += " | " + lista.dsLista + " | ";
        }
/* 
        if (lista.emails != null && lista.emails.length > 0) {
            html += " <a href='mailto:" + lista.emails[0].address + "'>"
                    + lista.emails[0].address + "</a> ";
        } */

        html += "<input type='button' value='-' title='Apagar este contato' onclick='removelista("
                + lista.idLista + ")'>";

        html += "</li>";

    }

    html += "</ul>";

    $("#result").html(html);
}

$(function() {
    
    findAll(renderList);

    $("#searchName").keyup(function(event) {
        if (event.keyCode == 13) {
            $("#btnSearch").click();
        }
    });

});


</script>
<title>Home</title>
</head>
<body>
<h1>${mensagem }</h1>

    <div id="actions">

        <fieldset>
            <legend>Buscar Lista</legend>
            <label>Nome: </label> <input type="text" id="searchName">
            <input type="button" id="btnSearch" value="Buscar"
                onclick="search();">
        </fieldset>

    </div>
    
     <div id="result"></div>

    <input type="button" value="Novo" onclick="newlista();">

    <br />
    <br />

    <div id="form" style="visibility: hidden; display: none;">

        <form>
            <fieldset>
                <legend id="fieldset"></legend>
                <input id="listaId" type="hidden"> <label
                    for="txtName">Nome: </label> <input id="txtName"
                    type="text" name="name" /><br /> Phones: <input
                    type="button" value="+"
                    onclick="addInput('#phones', '', '')">
                <div id="phones"></div>
                E-mails: <input type="button" value="+"
                    onclick="addInput('#emails', '', '')">
                <div id="emails"></div>
                <br /> <input id="btnSave" type="button" value="Salvar"
                    onclick="saveOrUpdate();"> <input
                    id="btnCancel" type="reset" value="Cancelar"
                    onclick="cancel();">

            </fieldset>
        </form>
    </div>
</body>
</html>