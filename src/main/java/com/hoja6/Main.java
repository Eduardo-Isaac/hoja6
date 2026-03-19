import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione implementación:");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int opcion = sc.nextInt();
        sc.nextLine();

        Map<String, String> inventario = MapFactory.crearMapa(opcion);
        Inventario.leerArchivo(inventario);

        Map<String, Integer> carrito = new HashMap<>();

        int op = 0;

        while (op != 7) {

            System.out.println("\n1. Agregar producto");
            System.out.println("2. Buscar categoría");
            System.out.println("3. Mostrar carrito");
            System.out.println("4. Mostrar carrito ordenado");
            System.out.println("5. Mostrar inventario");
            System.out.println("6. Inventario ordenado");
            System.out.println("7. Salir");

            op = sc.nextInt();
            sc.nextLine();

            if (op == 1) {
                System.out.println("Ingrese producto:");
                String producto = sc.nextLine();

                if (inventario.containsKey(producto)) {
                    carrito.put(producto, carrito.getOrDefault(producto, 0) + 1);
                    System.out.println("Agregado");
                } else {
                    System.out.println("Producto no existe");
                }
            }

            else if (op == 2) {
                System.out.println("Ingrese producto:");
                String producto = sc.nextLine();
                Inventario.buscarCategoria(inventario, producto);
            }

            else if (op == 3) {
                for (String p : carrito.keySet()) {
                    System.out.println(p + " - " + inventario.get(p) + " - Cantidad: " + carrito.get(p));
                }
            }

            else if (op == 4) {
                TreeMap<String, Integer> ordenado = new TreeMap<>(carrito);

                for (String p : ordenado.keySet()) {
                    System.out.println(p + " - " + inventario.get(p) + " - Cantidad: " + ordenado.get(p));
                }
            }

            else if (op == 5) {
                Inventario.mostrarInventario(inventario);
            }

            else if (op == 6) {
                Inventario.mostrarInventarioOrdenado(inventario);
            }
        }
    }
}