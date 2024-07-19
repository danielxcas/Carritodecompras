/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Carrito;
import modelo.Producto;
import modelo.ProductoDao;

/**
 *
 * @author user
 */
public class Controlador extends HttpServlet {

   ProductoDao pdao = new ProductoDao();
   Producto p=new Producto();
    List<Producto> productos = new ArrayList<>();
    List<Carrito> listaCarritos = new ArrayList<>();
    int item;
    int cantidad=1;
    double totalPagar=0.0;
    int idp;
    Carrito car;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          String accion = request.getParameter("accion");
        productos = pdao.listar();
        
try {
    switch (accion) {
        case "Comprar":
               try {
    idp = Integer.parseInt(request.getParameter("id"));
    p = pdao.listarId(idp);
    item = item + 1;
    car = new Carrito();
    car.setItem(item);
    car.setIdProducto(p.getIdProducto());
    car.setNombres(p.getNombre());
    car.setDescripcion(p.getDescripcion());
    car.setPrecioCompra(p.getPrecio());
    car.setCantidad(cantidad);
    car.setSubTotal(cantidad * p.getPrecio());
    listaCarritos.add(car);
    for (int i = 0; i < listaCarritos.size(); i++) {
        totalPagar = totalPagar + listaCarritos.get(i).getSubTotal();
    }
    request.setAttribute("totalPagar",totalPagar);
    request.setAttribute("carrito", listaCarritos);
    request.setAttribute("contador", listaCarritos.size());
    request.getRequestDispatcher("vistas/carrito.jsp").forward(request, response);
} catch (NumberFormatException e) {
    e.printStackTrace();
} catch (Exception e) {
    e.printStackTrace();
}
            break;
        case "Agregarcarrito":
            try {
                int pos = 0;
                cantidad=1;
                idp = Integer.parseInt(request.getParameter("id"));
                p = pdao.listarId(idp);
                if (listaCarritos.size()>0) {
                    for (int i = 0; i < listaCarritos.size(); i++) {
                        if (idp==listaCarritos.get(i).getIdProducto()) {
                            pos=i;
                        }
                    }
                    if (idp==listaCarritos.get(pos).getIdProducto()) {
                        cantidad=listaCarritos.get(pos).getCantidad()+cantidad;
                        double subtotal=listaCarritos.get(pos).getPrecioCompra()*cantidad;
                        listaCarritos.get(pos).setSubTotal(subtotal);
                        listaCarritos.get(pos).setCantidad(cantidad);
                    } else {
                item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombres(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * p.getPrecio());
                listaCarritos.add(car);    
                    }
  
                } else {
                 item = item + 1;
                car = new Carrito();
                car.setItem(item);
                car.setIdProducto(p.getIdProducto());
                car.setNombres(p.getNombre());
                car.setDescripcion(p.getDescripcion());
                car.setPrecioCompra(p.getPrecio());
                car.setCantidad(cantidad);
                car.setSubTotal(cantidad * p.getPrecio());
                listaCarritos.add(car);   
                }
                
                request.setAttribute("contador", listaCarritos.size());
                request.getRequestDispatcher("Controlador?accion=home").forward(request, response);
                
            } catch (NumberFormatException e) {
                // Manejo de excepción si el parámetro 'id' no es un número válido
                e.printStackTrace();
            } catch (Exception e) {
                // Manejo de cualquier otra excepción
                e.printStackTrace();
            }
            break;
            case"Delete":
                try {
    int idproducto = Integer.parseInt(request.getParameter("idp"));
    for (int i = 0; i < listaCarritos.size(); i++) {
        if (listaCarritos.get(i).getItem() == idproducto) {
            listaCarritos.remove(i);
            break; // Assuming you only want to remove the first match
        }
    }
    request.getRequestDispatcher("Controlador?accion=Carrito").forward(request, response);
} catch (NumberFormatException e) {
    e.printStackTrace();
   
} catch (Exception e) {
    e.printStackTrace();
}

            break;
            case "ActualizarCantidad":
                int idpro=Integer.parseInt(request.getParameter("idp"));
                int cant=Integer.parseInt(request.getParameter("Cantidad"));
                for (int i = 0; i < listaCarritos.size(); i++) {
                    if (listaCarritos.get(i).getIdProducto()==idpro) {
                        listaCarritos.get(i).setCantidad(cant);
                        double st=listaCarritos.get(i).getPrecioCompra()*cant;
                        listaCarritos.get(i).setSubTotal(st);
                    }
                }
                break;
        case "Carrito":
            totalPagar=0.0;
            request.setAttribute("carrito",listaCarritos);
            for (int i = 0; i <listaCarritos.size(); i++) {
                totalPagar=totalPagar+listaCarritos.get(i).getSubTotal();
            }
            request.setAttribute("totalPagar",totalPagar);
            request.getRequestDispatcher("vistas/carrito.jsp").forward(request, response);
            
            break;
        default:
            request.setAttribute("productos", productos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
            break;
    }
} catch (Exception e) {
    // Manejo de cualquier excepción fuera del switch
    e.printStackTrace();
    request.setAttribute("error", "Ocurrió un error al procesar la solicitud.");
    request.getRequestDispatcher("index.jsp").forward(request, response);
}
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
