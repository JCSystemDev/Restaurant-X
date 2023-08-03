package cl.awakelab.spring7.algotimosypruebas;

public class CalculoCantidad implements ICalculoDescuento{
    @Override
    public double descuento(int cantidadPlatos, int capacidadMesa) {
        if (cantidadPlatos <= 5) {
            return 0.0;
        } else if (cantidadPlatos < 10) {
            return 0.03;
        } else if (cantidadPlatos <= 15) {
            return 0.05;
        } else {
            return 0.3;
        }
    }
}
