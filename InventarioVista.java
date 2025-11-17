package vista;

import modelo.Producto;
import java.util.List;
import java.util.Scanner;

public class InventarioVista {
    
    private Scanner scanner;

    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }

   
    public int mostrarMenu() {
        System.out.println("\n--- MENU INVENTARIO ---");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto por SKU");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opcion: ");
        String line = scanner.nextLine();
        try {
            return Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    
    public Producto pedirDatosUsuario() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine().trim();

        System.out.print("SKU: ");
        String sku = scanner.nextLine().trim();

        int cantidad = 0;
        while (true) {
            System.out.print("Cantidad: ");
            String c = scanner.nextLine();
            try {
                cantidad = Integer.parseInt(c.trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Cantidad inválida. Intente de nuevo.");
            }
        }

        double precio = 0.0;
        while (true) {
            System.out.print("Precio unitario: ");
            String p = scanner.nextLine();
            try {
                precio = Double.parseDouble(p.trim());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Intente de nuevo.");
            }
        }

        return new Producto(nombre, sku, cantidad, precio);
    }

    
    public String pedirSku() {
        System.out.print("Ingrese el SKU: ");
        return scanner.nextLine().trim();
    }

    
    public void mostrarProducto(Producto producto) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
        } else {
            System.out.println(producto.toString());
        }
    }

    
    public void mostrarProductos(List<Producto> productos) {
        if (productos == null || productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : productos) {
                System.out.println(p.toString());
            }
        }
    }

    
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

