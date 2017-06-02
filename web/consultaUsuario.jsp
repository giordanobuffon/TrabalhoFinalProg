<%-- 
    Document   : consultaUsuario
    Created on : 05/05/2017, 09:04:20
    Author     : DAP
--%>

<%@page import="br.edu.ifrs.modelo.bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Lista de Usuários</h1>
        <hr>
        
        <form action="UsuarioControl">
            <input type="hidden" name="op" value="CONSULTA">
            
            <label for="nome">Nome: </label>
            <input type="text" id="nome" name="nome" size="20">
            
            <input type="submit" value="Pesquisar">
        </form>
        
        <hr>
        <a href="UsuarioControl?op=NOVO">Adicionar</a>&nbsp;
        <a href="index.html">Ir para o Início</a>
        <table border="1" cellpadding="1" cellspacing="0">
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Matrícula</th>
                <th>Situação</th>
                <th>Ações</th>
            </tr>
            <%
                Usuario[] usus = (Usuario[])request.getAttribute("usuarios");
                
                for (int i=0; i<usus.length; i++) {
            %>
                    <tr>
                        <td><%= usus[i].getCpf()%></td>
                        <td><%= usus[i].getNome()%></td>
                        <td><%= usus[i].getMatricula()%></td>
                        <td><%= usus[i].getSituacao()%></td>
                        <td>
                            <a href="UsuarioControl?op=CONSATUALIZAR&cpf=<%= usus[i].getCpf()%>">Atualizar</a>&nbsp;
                            <a href="UsuarioControl?op=EXCLUIR&cpf=<%= usus[i].getCpf()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                }
            %>
        </table>
        
    </body>
</html>