package menu;
import java.util.Scanner;
public class Menu {
    private static Scanner teclado = new Scanner(System.in);
    
/**
 * @param el parametro PedirNumeros se utiliza para solicitar al usuario los numeros a operar
 * @param menuOpciones muestra las opciones establecidas en el codigo para operar los numeros
 * @param repetir se usa para volver a mostrar el menu al terminar un calculo
 * @param dividir se utiliza para abarcar los procedimientos en los que intervenga el numero cero(0)
 * 
 * @return revuelve un booleano indicando si el numero es correcto
 */
    
    public int[] pedirNumeros(){
        int[] ret = new int[2];
        System.out.print ("Operando 1: ");
        ret [0] = teclado.nextInt();
        System.out.print ("Operando 2: ");
        ret [1] = teclado.nextInt();
        return ret;
    }
    
    public String menuOpciones() {
        String ret = "";
        do {
            System.out.print ("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||
                (ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||
                (ret.equalsIgnoreCase("%"))
                ));
                return ret;
    }
    
    public boolean repetir(){
        boolean ret = false;
        String respuesta;
        do {
            System.out.print ("�Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))
                    ));
                    
        if (respuesta.equalsIgnoreCase("s")){
            ret = true;
        }
        return ret;
    }
    public double divide(double valor1, double valor2) {
        try {
            if (valor2 == 0) {
                throw new ArithmeticException("No se permite la división entre cero");
            }
            return valor1 / valor2;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }
}