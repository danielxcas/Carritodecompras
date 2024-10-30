/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
    private static Calendar calendar = Calendar.getInstance(); // Inicializar el Calendar
    private static String fecha; // Variable para almacenar la fecha en formato String

    public Fecha() {
        // Constructor vacío
    }

    // Método para obtener la fecha en formato "dd-MM-yyyy"
    public static String getFecha() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        fecha = sdf.format(calendar.getTime()); // Asignar el valor formateado a la variable fecha
        return fecha; // Retornar la fecha formateada
    }

    // Método para obtener la fecha en formato "yyyy-MM-dd"
    public static String getFechaBD() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha = sdf.format(calendar.getTime()); // Asignar el valor formateado a la variable fecha
        return fecha; // Retornar la fecha formateada
    }
}
