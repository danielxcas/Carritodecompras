<%-- 
    Document   : error
    Created on : 17 jul. 2024, 14:15:05
    Author     : user
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
    <title>Mensaje de Éxito</title>
</head>
<body>
    <div class="container mt-4">
        <div class="col-sm-4 mx-auto"> <!-- Centrar la columna -->
            <div class="alert alert-success" role="alert">
                <h4 class="alert-heading">¡Error al generar!</h4>
                <hr>
                <a href="Controlador?accion=home" class="btn btn-warning">Volver</a>
            </div>
        </div>
    </div>

    <!-- Scripts de Bootstrap (opcional, solo si necesitas funcionalidades adicionales) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

