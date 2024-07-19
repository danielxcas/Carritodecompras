<%-- 
    Document   : carrito
    Created on : 14 jul. 2024, 21:51:54
    Author     : user
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
            <a class="nav-link " href="Controlador?accion=Home">Seguir Comprando</a>
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
        <div class="container-mt-4">
            <h3>CARRITO</h3>
            <br>
            <div class="row">
                <div class="col-sm-8">
                    <table class="table table-hover">
                      <thead>
                        <tr>
                            <th>ITEM</th>
                            <th>NOMBRES</th>
                            <th>DESCRIPCION</th>
                            <th>PRECIO</th>
                            <th>CANT</th>
                            <th>SUBTOTAL</th>
                            <th>ACCION</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="car" items="${carrito}">
                        <tr> 
                            <td>${car.getItem()}</td> 
                            <td>${car.getNombres()}</td>
                            <td>${car.getDescripcion()}
                                <img src="ControladorIMG?id=${car.getIdProducto()}" width="100" height="100">
                            </td>                        
                            <td>${car.getPrecioCompra()}</td>
                            <td>
                                <input type="hidden" id="idpro" value="${car.getPrecioCompra()}" >
                                <input type="number" id="Cantidad" value="${car.getCantidad()}" class="form-control text-center " min="1" >
                            </td> 
                            <td>${car.getSubTotal()}</td>
                            <td>
                                <input type="hidden" id="idp" value="${car.getIdProducto()}" >
                                <a href="Controlador?accion=Delete&idp=${car.getItem()}">eliminar</a>
                               
                            </td>
                        </tr>
                        
                        </c:forEach>
                        
                    </tbody>   
                    </table>
                                   
                </div>
                <div class="col-sm-4">
                    <div>
                        <div class="card-header">
                            <h3>Generar Compra</h3>
                       </div>
                        <div class="card-body">
                            <label>Subtotal:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                            <label>Descuento:</label>
                            <input type="text" value="$0.0" readonly="" class="form-control">
                            <label>Total Pagar:</label>
                            <input type="text" value="$.${totalPagar}0" readonly="" class="form-control">
                       </div>
                        <div class="card-footer">
                            <a href="#" class="btn btn-info btn-block" >Realizar Pago</a>  
                            <a href="#" class="btn btn-danger btn-block">Generar Compra</a>
                       </div>
                    </div>
                        
                </div>
            </div>  
            
        </div>
   <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="../js/funciones.js" type="text/javascript"></script>
    </body>
</html>








