<%-- 
    Document   : formPerfil
    Created on : 06/05/2016, 08:22:22
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Setor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete Virtual</title>
        <script src="validacoes.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>Cadastro de Setores</h1>
        <hr>
        <%
            Setor s = new Setor();
            if (request.getSession().getAttribute("setor") != null) {
                s = (Setor)request.getSession().getAttribute("setor");
            }
        %>    
  <!-- onsubmit="return validarPerfil();" -->      
        <form action="SetorControl" >
            <input type="hidden" name="op" value="<%= (s.getId() == 0 ? "INSERIR":"ATUALIZAR") %>">
            <input type="hidden" name="id" value="<%= s.getId() %>">
            
            <label for="nome">Nome: </label><br>
            <input type="text" name="nome" id="nome" size="50" value="<%= s.getNome() %>"><br>
            
            <label for="pai">Setor Pai: </label><br>
            <select name="pai" id="pai">
                <% 
                    Setor[] setores = (Setor[])request.getAttribute("setores");
                    for (int i=0; i<setores.length; i++) {
                %>
                        <option value="<%= setores[i].getId()%>" <%= (setores[i].getId() == s.getPai().getId() ? "selected":"")%>><%= setores[i].getNome()%></option>
                <%
                    }
                %>
            </select><br>
            
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpar">
        </form>
            <br><br>
            <a href="SetorControl?op=LISTA">Voltar</a>
    </body>
</html>
