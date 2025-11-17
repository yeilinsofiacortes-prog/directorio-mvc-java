package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;
import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;

    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    Producto p = vista.pedirDatosUsuario();
                    baseDatos.agregarProducto(p);
                    vista.mostrarMensaje("Producto agregado correctamente.");
                    break;
                case 2:
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                case 3:
                    List<Producto> lista = baseDatos.buscarTodos();
                    vista.mostrarProductos(lista);
                    break;
                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.EliminarProducto(skuEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("Producto eliminado correctamente.");
                    } else {
                        vista.mostrarMensaje("No se encontró el producto para eliminar.");
                    }
                    break;
                case 5:
                    salir = true;
                    vista.mostrarMensaje("Saliendo... ¡Hasta luego!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
