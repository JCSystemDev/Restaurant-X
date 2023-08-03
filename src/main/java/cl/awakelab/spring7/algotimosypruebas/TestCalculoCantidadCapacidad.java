package cl.awakelab.spring7.algotimosypruebas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculoCantidadCapacidad {
    @Test
    public void testDescuentoNormal() {
        CalculoCantidadCapacidad calculoCantidadCapacidad = new CalculoCantidadCapacidad();

        // Prueba con 6 platos y mesa de capacidad 3 (15% de descuento)
        assertEquals(0.15, calculoCantidadCapacidad.descuento(6, 3));

        // Prueba con 12 platos y mesa de capacidad 5 (20% de descuento)
        assertEquals(0.2, calculoCantidadCapacidad.descuento(12, 5));
    }

    @Test
    public void testDescuentoBorde() {
        CalculoCantidadCapacidad calculoCantidadCapacidad = new CalculoCantidadCapacidad();

        // Prueba con 5 platos y mesa de capacidad 4 (sin descuento)
        assertEquals(0.0, calculoCantidadCapacidad.descuento(5, 4));

        // Prueba con 15 platos y mesa de capacidad 6 (30% de descuento)
        assertEquals(0.3, calculoCantidadCapacidad.descuento(15, 6));

        // Prueba con 2 platos y mesa de capacidad 2 (15% de descuento)
        assertEquals(0.15, calculoCantidadCapacidad.descuento(2, 2));
    }
}
