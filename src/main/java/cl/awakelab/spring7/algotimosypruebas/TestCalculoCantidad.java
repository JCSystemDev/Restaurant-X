package cl.awakelab.spring7.algotimosypruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculoCantidad {
    @Test
    public void testDescuentoNormal() {
        CalculoCantidad calculoCantidad = new CalculoCantidad();

        // Prueba con 6 platos (3% de descuento)
        assertEquals(0.03, calculoCantidad.descuento(6, 0));

        // Prueba con 12 platos (5% de descuento)
        assertEquals(0.05, calculoCantidad.descuento(12, 0));
    }

    @Test
    public void testDescuentoBorde() {
        CalculoCantidad calculoCantidad = new CalculoCantidad();

        // Prueba con 5 platos (sin descuento)
        assertEquals(0.0, calculoCantidad.descuento(5, 0));

        // Prueba con 10 platos (5% de descuento)
        assertEquals(0.05, calculoCantidad.descuento(10, 0));

        // Prueba con 15 platos (5% de descuento)
        assertEquals(0.05, calculoCantidad.descuento(15, 0));

        // Prueba con 16 platos (30% de descuento)
        assertEquals(0.3, calculoCantidad.descuento(16, 0));
    }
}
