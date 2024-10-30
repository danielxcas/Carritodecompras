/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import modelo.Carrito;
import modelo.Cliente;
import modelo.Compra;

/**
 *
 * @author Daniel
 */
public class CompraDao {
   
    
 Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rx;
    
    public int GenerarCompra(Compra compra) {
        int r = 0; // Inicializar el contador de filas afectadas
        int idCompras = 0; // Inicializar el ID de la compra
        String queryInsertCompra = "INSERT INTO compras (idCliente, idPago, FechaCompras, Monto, Estado) VALUES (?, ?, ?, ?, ?)";
        
        try {
            con = cn.obtenerConexion();
            ps = con.prepareStatement(queryInsertCompra);
            
            // Asignar los valores a la declaración
            ps.setInt(1, compra.getCliente().getId()); // Asume que el objeto Cliente tiene un método getId()
            ps.setInt(2, compra.getIdpago());
            ps.setString(3, compra.getFecha());
            ps.setDouble(4, compra.getMonto());
            ps.setString(5, compra.getEstado());

            // Ejecutar la inserción de la compra
            r = ps.executeUpdate(); // Ejecuta la inserción
            
            // Recuperar el ID de la última inserción
            String idQuery = "SELECT LAST_INSERT_ID() AS idCompras";
            ps = con.prepareStatement(idQuery);
            rx = ps.executeQuery(); // Ejecuta la consulta para obtener el ID
            
            if (rx.next()) {
                idCompras = rx.getInt("idCompras"); // Obtener el ID de la compra insertada
            }

            // Insertar detalles de la compra
            for (Carrito detalle : compra.getDetallecompras()) {
                String queryInsertDetalle = "INSERT INTO detalle_compras (idProducto, idCompras, Cantidad, PrecioCompra) VALUES (?, ?, ?, ?)";
                ps = con.prepareStatement(queryInsertDetalle);
                ps.setInt(1, detalle.getIdProducto()); // Asume que el objeto Carrito tiene un método getIdProducto()
                ps.setInt(2, idCompras);
                ps.setInt(3, detalle.getCantidad());
                ps.setDouble(4, detalle.getPrecioCompra());
                r += ps.executeUpdate(); // Sumar las filas afectadas
            }

        } catch (Exception e) {
            e.printStackTrace(); // Imprimir detalles del error en caso de excepción
        } finally {
            // Cerrar recursos
            try {
                if (rx != null) rx.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace(); // Imprimir detalles del error en caso de excepción al cerrar
            }
        }

        return r; // Retornar el número total de filas afectadas (compras + detalles)
    }


    
}
