/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios;
import java.io.Serializable;
/**
 *En esta clase vamos a registrar los datos de una persona
 * @author Víctor
 */
public class AgendaTelegono implements Serializable{
    String nombrePersona;
    String apellidos;
    int telefono;
    
    public AgendaTelegono(String nombre, String apellidos, int telefono){
        this.nombrePersona=nombre;
        this.apellidos =apellidos;
        this.telefono=telefono;
    }
    
    public void mostrarAgenda(){
        System.out.println("Nombre " + nombrePersona + "   Apellidos: " + apellidos + "   Telefono: " + telefono);        
    }
}
