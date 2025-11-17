package modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {
    
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    
    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    
    public Producto buscarProductoSku(String sku) {
        if (sku == null) return null;
        for (Producto p : productos) {
            if (p.getSku().equalsIgnoreCase(sku.trim())) {
                return p;
            }
        }
        return null;
    }

    
    public List<Producto> buscarTodos() {
        return productos;
    }

    
    public boolean EliminarProducto(String sku) {
        Producto p = buscarProductoSku(sku);
        if (p != null) {
            productos.remove(p);
            return true;
        }
        return false;
    }
}


