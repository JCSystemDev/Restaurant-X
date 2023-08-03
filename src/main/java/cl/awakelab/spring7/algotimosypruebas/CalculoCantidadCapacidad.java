package cl.awakelab.spring7.algotimosypruebas;

public class CalculoCantidadCapacidad implements ICalculoDescuento{
    @Override
    public double descuento(int cantidadPlatos, int capacidadMesa) {
        if (cantidadPlatos > 5 && capacidadMesa < 4) {
            return 0.15;
        } else if (cantidadPlatos >= 5 && cantidadPlatos <= 15 && capacidadMesa >= 4 && capacidadMesa <= 6) {
            return 0.2;
        } else if (capacidadMesa > 6 && cantidadPlatos > 15) {
            return 0.3;
        } else if (capacidadMesa == 2 && cantidadPlatos > 5) {
            return 0.15;
        } else {
            return 0.0;
        }
    }
}
