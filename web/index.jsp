<%-- 
    Document   : index
    Created on : 14 jul. 2024, 21:35:34
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
   <link href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" rel="stylesheet">
    </head>
   
    <body>
          <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Mercados dorita</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="Controlador?accion=home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Oferta del dia</a>
        </li>
       
        <li class="nav-item">
            <a class="nav-link " href="Controlador?accion=Carrito" aria-disabled="true"><i class="fas fa-cart-plus">(<label style=" color: darkorange">${contador}</label>)</i>Carrito</a>
        </li>
      </ul>
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
        <ul class="navbar-nav">
             <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            IniciarSesion
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
        </ul>
    </div>
  </div>
              
</nav>  
        <div class="container-mt-2">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                    <div class="card">
                        <div class="card-header">
                            <label>${p.getNombre()}</label>
                        </div>
                        <div class="card-body">
                            <i>$.${p.getPrecio()}</i>
                            <img src="ControladorIMG?id=${p.getIdProducto()}" width="300" height="200" alt="alt"/>
                        </div>
                        <div class="card-footer">
                            <label>${p.getDescripcion()}</label>
                            <div>
                                <a class="btn btn-outline-info" href="Controlador?accion=Agregarcarrito&id=${p.getIdProducto()}">Agregarcarrito</a>
                            <a class="btn btn-danger" href="Controlador?accion=Comprar&id=${p.getIdProducto()}">Comprar</a>                                 
                            </div>
                             </div>
            </div>
            </div>   
                </c:forEach>
               
            </div>
              </div>
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>    
    </body>
   
</html>
