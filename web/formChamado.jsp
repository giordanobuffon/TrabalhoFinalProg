<%-- 
    Document   : formChamado
    Created on : 02/06/2017, 09:46:01
    Author     : 10070241
--%>

<%@page import="br.edu.ifrs.modelo.bean.Perfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Chamados</h1> 
        <hr>
        <%
            Perfil p = new Perfil();
            if (request.getSession().getAttribute("perfil") != null) {
                p = (Perfil)request.getSession().getAttribute("perfil");
            }
        %>    
  <!-- onsubmit="return validarPerfil();" -->      
        <form action="" >
            <input type="hidden" name="op" value="INSERIR">
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50"><br>
            
            <label for="solicitante">Solicitante: </label><br>
            <select name="solicitante" id="solicitante" required>
                <option value="">Nenhum Solicitante Selecionado</option>
                <option value="aluno" >Aluno</option>
                <option value="servidor" >Servidor</option>
                <option value="pais" >Pais</option>
                <option value="comunidade externa" >Comunidade externa</option>
            </select><br>
            
            <label for="email">E-mail: </label>
            <input type="email" name="email" id="email" size="40" required><br>
            
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
            <br><br>
            <a href="PerfilControl?op=LISTA">Voltar</a>
    </body>
</html>
