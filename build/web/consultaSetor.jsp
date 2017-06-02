<%-- 
    Document   : consultaPerfil
    Created on : 01/06/2016, 08:34:25
    Author     : DTI
--%>

<%@page import="br.edu.ifrs.modelo.bean.Setor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gabinete</title>
    </head>
    <body>
        <h1>Lista de Setores</h1>
        <hr>
        
        <form action="SetorControl">
            <input type="hidden" name="op" value="CONSULTA">
            
            <label for="nome">Nome: </label>
            <input type="text" id="nome" name="nome" size="20">
            
            <input type="submit" value="Pesquisar">
        </form>
        
        <hr>
        <a href="SetorControl?op=NOVO">Adicionar</a>&nbsp;
        <a href="index.html">Ir para o Início</a>
        <table border="1" cellpadding="1" cellspacing="0">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Setor Pai</th>
            </tr>
            <%
                Setor[] set = (Setor[])request.getAttribute("setores");
                
                for (int i=0; i<set.length; i++) {
                    if (set[i].getId() > -1) {
            %>
                    <tr>
                        <td><%= set[i].getId()%></td>
                        <td><%= set[i].getNome()%></td>
                        <td><%= set[i].getPai().getNome()%></td>
                        <td>
                            <a href="SetorControl?op=CONSATUALIZAR&id=<%= set[i].getId()%>">Atualizar</a>&nbsp;
                            <a href="SetorControl?op=EXCLUIR&id=<%= set[i].getId()%>">Excluir</a>
                        </td>
                    </tr>
            <%
                    }
                }
            %>
        </table>
        
    </body>
</html>
