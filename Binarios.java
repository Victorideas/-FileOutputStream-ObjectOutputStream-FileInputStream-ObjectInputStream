/*
 * Esta clase va a lanzar los metodos creados en las diferentes clases creadas. 
 */
package binarios;

import java.io.IOException;

/**
 * Esta clase contentra el metodo main, desde donde se lanzaran todas las operaciones
 * @author Victor
 */
public class Binarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Constructores cons = new Constructores("Numeros.dat"); //Crea fichero a traves del constructor con parametros
        Constructores cons1 = new Constructores(); //Crea fichero a traves del constructor SIN parametros
        //cons.crearEnteros();
        //cons.leerEnteros();
        cons.crearPersona();
        cons.leerPersona();
        cons.crearAgenda("Carlos", "Rodriguez", 645875421); //Crea agenda pasandole los datos por parametro
        cons.crearAgenda("Miguel", "Fernandez", 640125487); 
        cons.leerAgenda();
        
        /*Utilidades: 
        - Si abro los archicos con el editor de texto salen caracteres raros. No se entiende nada.
        - Si lo abro con Libre Office Cal y lo configuro con UTF8, se pueden leer los datos UTF, el resto no.*/
       
        cons.crearAgendaUTF("Lorenzo", "Gonzalez", 648952357); //Modifico el metodo crearAgenda para que cree archivos .ods leibles por Libre office Calc

       

    }
    
}
