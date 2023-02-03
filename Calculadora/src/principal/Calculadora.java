package principal;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import menu.Menu;
import operaciones.Operaciones;

public class Calculadora {
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());

	public static void main(String[] args) {
		int resultado = 0;
		String operacion = "";
		int[] operandos = new int[2];
		Handler consoleHandler = null;
		Handler fileHandler = null;
		try {
			consoleHandler = new ConsoleHandler();
			fileHandler = new FileHandler("./operaciones.log");
			
			LOGGER.setUseParentHandlers(false);
			LOGGER.addHandler(consoleHandler);
			LOGGER.addHandler(fileHandler);

			consoleHandler.setLevel(Level.WARNING);
			fileHandler.setLevel(Level.ALL);
			LOGGER.setLevel(Level.ALL);
			
		} catch (IOException exception) {
			LOGGER.log(Level.WARNING, "Ocurrió un error en FileHandler.", exception);
			}
		Menu menu = new Menu();
		Operaciones operaciones = new Operaciones();
		
		do {
			operandos = menu.pedirNumeros();
			operacion = menu.menuOpciones();

			if (operacion.equalsIgnoreCase("+")) {
				resultado = operaciones.sumar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("-")) {
				resultado = operaciones.restar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("*")) {
				resultado = operaciones.multiplicar(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
			} else if (operacion.equalsIgnoreCase("/")) {
				try {
					resultado = operaciones.dividir(operandos[0], operandos[1]);
					System.out.println("Resultado: " + resultado);
					LOGGER.log(Level.FINE, "El resultado ha sido completado--->" + resultado);
				} catch (ArithmeticException excepcion) {
					LOGGER.log(Level.WARNING, "Division entre 0", excepcion);
				}
			} else if (operacion.equalsIgnoreCase("%")) {
				resultado = operaciones.resto(operandos[0], operandos[1]);
				System.out.println("Resultado: " + resultado);
			} else {
				System.out.println("Operacion no valida");
			}
		} while (menu.repetir());
	}
}