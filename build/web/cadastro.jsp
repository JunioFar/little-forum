<%-- 
    Document   : cadastro
    Created on : 08/07/2019, 14:05:36
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <h1>Cadastre-se</h1>
        <main class="corpo">
            <section>
                <form method="POST" action="cadastro">
                    <p>Nome de Login: <input type="text" name="login" placeholder="ex. pauloAt" /></p>
                    <p>Nome e Sobrenome: <input type="text" name="nome" placeholder="ex. Paulo Augusto" /></p>
                    <p>Email: <input type="email" name="email" placeholder="ex. paulo@email.com" /></p>
                    <p>Senha: <input type="password" name="senha"/></p>
                    <input type="submit" value="Cadastrar"/>
                </form>
                <p>Ja é cadastrado? <a href="index.jsp">Clique Aqui</a></p>
            </section>
        </main>
    </body>
</html>
