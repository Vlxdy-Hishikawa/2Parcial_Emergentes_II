
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="author" content="VLADIMIR HUANCA">
        <meta name="viewport" content="with=device-width, initial-scale=1.0">
        <link rel="shortcut icon" href="Logoo.png">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet" >
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

        <title>2º PARCIAL</title>
    </head>
    <body>
        <div class="container">
            <h1>ROL</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="opcion" value="roles" />
            </jsp:include>
            <br>
            <a href="RolControlador?action=add" class="btn btn-primary btn-sm"><i class="fas fa-plus-circle"></i> Nuevo </a>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>DESCRIPCION</th>
                    <th></th>
                    <th></th>
                </tr>
                <c:forEach var="item" items="${rols}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td><a href="RolControlador?action=edit&id=${item.id}"><i class="fas fa-edit"></i></a></td>
                    <td><a href="RolControlador?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro ???'))">
                            <i class="fas fa-trash-alt"></i>
                        </a>
                    </td> </tr>
                </c:forEach>      
            </table>
        </div>
<footer>
        <p><br><br>
            <h4 id="heading" align="center" style="color:black;">DEVELOPED &#x1F497; by <a style="color:black;" ><strong>VLADIMIR HUANCA</strong></a></h4>
        </p>
    </footer>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8" crossorigin="anonymous"></script>

    </body>
</html>
