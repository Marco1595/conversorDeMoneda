package modelos;
import calculos.ConsultaMoneda;
import calculos.Historial;
import calculos.Moneda;
import calculos.Operaciones;

import java.io.IOException;
import java.util.Scanner;

public class ConvertidorMoneda {
    private final ConsultaMoneda tipoDeCambio;
    private final Operaciones operacion;

    public ConvertidorMoneda() {
        this.tipoDeCambio = new ConsultaMoneda();
        this.operacion = new Operaciones();
    }

    public void iniciar() throws IOException {
        Scanner lectura = new Scanner(System.in);

        while (true) {
            mostrarMenu();

            String opcion = lectura.nextLine();

            if (opcion.equalsIgnoreCase("6")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            String monedaOrigen = "";
            String monedaDestino = "";

            switch (opcion) {
                case "1":
                    monedaOrigen = "USD";
                    monedaDestino = "MXN";
                    break;
                case "2":
                    monedaOrigen = "MXN";
                    monedaDestino = "USD";
                    break;
                case "3":
                    monedaOrigen = "EUR";
                    monedaDestino = "MXN";
                    break;
                case "4":
                    monedaOrigen = "MXN";
                    monedaDestino = "EUR";
                    break;
                case "5":
                    Historial.mostrarHistorial();
                    continue;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
                    continue;
            }

            System.out.println("Ingrese la cantidad a convertir:  ");
            Double cantidad = Double.valueOf(lectura.nextLine());
            Moneda moneda = tipoDeCambio.convertirMoneda(monedaOrigen, monedaDestino);
            operacion.operacionMoneda(moneda, cantidad);
        }

        lectura.close();
    }

    private void mostrarMenu() {
        System.out.println("***********************************");
        System.out.println("Bienvenido al Convertor de Monedas ");
        System.out.println("1) Dolar -> Peso Mexicano");
        System.out.println("2) Peso Mexicano -> Dolar");
        System.out.println("3) Euro -> Peso Mexicano");
        System.out.println("4) Peso Mexicano -> Euro");
        System.out.println("5) Mostrar historial");
        System.out.println("6) Salir.");
        System.out.println("***********************************");
        System.out.println("Elija una opción: ");
    }
}
