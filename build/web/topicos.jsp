<%-- 
    Document   : topicos
    Created on : 08/07/2019, 17:12:12
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Little Forum</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header class="cabecalho">
            <h1>Little Forum</h1>
            <a class="criar-topico-link" href="criar-topico.jsp">Criar Topico</a>
            <a class="ranking-link" href="exibeRanking">Ranking</a>
        </header>
        <main class="coo">
            <section class="section-topicos">
                <table id="topicos">
                    <thead>
                        <tr>
                            <th>Topicos</th>
                            <th>Autor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="topico" items="${topicos}">
                            <tr>
                                <td><a href="exibeTopico?id=${topico.getId()}">${topico.getTitulo()}</a></td>
                                <td>${topico.getLogin()}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section> 
        </main>   
    </body>
</html>
