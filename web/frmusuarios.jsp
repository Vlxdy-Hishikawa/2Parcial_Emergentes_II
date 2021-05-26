<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logoo.png">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>2º PARCIAL</title>
    </head>
    <body>
        <div class="container">
            <h1>FORMULARIO DE USUARIOS</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="usuarios" />
            </jsp:include>
            <br>
            <form action="UsuarioControlador" method="post" >
                <input type="hidden" name="id" value="${usuario.id}">
                <div class="form-group">
                    <label for="" class="form-label">USUARIO</label>
                    <input type="text" class="form-control" name="usuario" value="${usuario.usuario}" placeholder="Escriba su nombre" required>                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">CORREO ELECTRONICO</label>
                    <input type="email" class="form-control" name="correo" value="${usuario.correo}" placeholder="Escriba su correo electrónico" required>                    
                </div>
                <div class="form-group">
                    <label for="" class="form-label">CLAVE</label>
                    <input type="text" class="form-control" name="clave" value="${usuario.clave}" placeholder="Escriba su contraseña" required>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
