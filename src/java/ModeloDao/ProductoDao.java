/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDao;
import java.sql.SQLException;
import Config.Conexion;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import modelo.Producto;


/**
 *
 * @author user
 */
public class ProductoDao {
  Conexion cn=new Conexion();  
  Connection con;
 PreparedStatement ps;
     ResultSet rx;  
     public Producto listarId(int id){
    String sql="select * from producto where idProducto= "+id;
         Producto p=new Producto();
         try (Connection con=cn.obtenerConexion()){
             ps=con.prepareStatement(sql);
             rx=ps.executeQuery();
             while (rx.next()) {                 
                 p.setIdProducto(rx.getInt("idProducto"));
                p.setNombre(rx.getString("Nombres"));
                p.setFoto(rx.getBinaryStream("Foto"));
                p.setDescripcion(rx.getString("Descripcion"));
                p.setPrecio(rx.getDouble("Precio"));
                p.setStock(rx.getInt("Stock"));                  
             }
         } catch (Exception e) {
             e.printStackTrace();
         }   
    return p;
    }
   public List listar(){
     String sql="select * from producto ";
     List<Producto> lista=new ArrayList<>();
        try (Connection con=cn.obtenerConexion()){
             ps=con.prepareStatement(sql);
             rx=ps.executeQuery();         
             while (rx.next()) {                
             Producto p=new Producto();
             p.setIdProducto(rx.getInt(1));
             p.setNombre(rx.getString(2));
             p.setFoto(rx.getBinaryStream(3));
             p.setDescripcion(rx.getString(4));
             p.setPrecio(rx.getDouble(5));
             p.setStock(rx.getInt(6));
             lista.add(p);
             }
         } catch (SQLException e) {
          e.printStackTrace();
         }
     return lista;
     }
   public void listarImg(int id, HttpServletResponse response) {
    String sql = "SELECT Foto FROM producto WHERE idProducto=?";
    InputStream inputStream = null;
    OutputStream outputStream = null;
    BufferedInputStream bufferedInputStream = null;
    BufferedOutputStream bufferedOutputStream = null;

    try (Connection con = cn.obtenerConexion();
         PreparedStatement ps = con.prepareStatement(sql)) {

        // Set the id parameter in the SQL query
        ps.setInt(1, id);

        // Execute the query and obtain the result set
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                // Get the image as a binary stream
                inputStream = rs.getBinaryStream("Foto");
                outputStream = response.getOutputStream();
                bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedOutputStream = new BufferedOutputStream(outputStream);

                // Read the image data and write it to the output stream
                int i;
                while ((i = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(i);
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    } 
  
}
}
