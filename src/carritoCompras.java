
import java.awt.List;
import java.util.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gameV
 */
public class carritoCompras {
    private static ArrayList<String> productos = new ArrayList<>();
    
    public static void agregarProducto(String producto) {
        productos.add(producto);
    }
    
    public static ArrayList <String> getProductos(){
        return productos;
    }
    
}
