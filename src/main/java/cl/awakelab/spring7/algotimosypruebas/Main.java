package cl.awakelab.spring7.algotimosypruebas;
public class Main{
    public static void main(String[] args) {
        // Crear objetos de cálculo
        CalculoCantidad calculoCantidad = new CalculoCantidad();
        CalculoCantidadCapacidad calculoCantidadCapacidad = new CalculoCantidadCapacidad();

        // Ejemplo 1: Cálculo del descuento basado solo en cantidad de platos
        int cantidadPlatos1 = 3;
        int capacidadMesa1 = 4;
        double descuento1 = calculoCantidad.descuento(cantidadPlatos1, capacidadMesa1);
        System.out.println("Descuento 1: " + descuento1);

        // Ejemplo 2: Cálculo del descuento basado en cantidad de platos y capacidad de mesa
        int cantidadPlatos2 = 12;
        int capacidadMesa2 = 5;
        double descuento2 = calculoCantidadCapacidad.descuento(cantidadPlatos2, capacidadMesa2);
        System.out.println("Descuento 2: " + descuento2);
    }
}
