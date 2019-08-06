<%-- 
    Document   : criar-topico
    Created on : 08/07/2019, 19:09:39
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Criar Topico</title>
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <header class="cabecalho">
            <h1>Criar Topico</h1>
            <a class="ranking-link" href="recuperaTopicos">Voltar</a>
        </header>
        <main class="corpo">
            <section class="topico">
                <form method="POST" action="criarTopico">
                    <p>Titulo: <input type="text" name="titulo" placeholder="Digite seu titulo"></p>
                    <p>Mensagem:</p> <textarea name="conteudo" rows="10" cols="40" placeholder="Digite sua mensagem"></textarea>
                    <input type="submit" value="Postar">
                </form>
            </section> 
        </main>   
    </body>
</html>
