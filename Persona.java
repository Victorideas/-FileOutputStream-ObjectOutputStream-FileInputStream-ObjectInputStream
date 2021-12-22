/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios;

import java.io.Serializable;

/**
 *Clase persona en la cual creare los objetos de Persona
 * @author Víctor
 */
public class Persona implements Serializable{
    String nombrePersona;
    int edad;
    int estatura;
    
    public Persona(String nombre, int edad, int estatura){
        this.nombrePersona=nombre;
        this.edad=edad;
        this.estatura=estatura;
    }
    
    public void mostrarPersona(){
        System.out.println("Nombre " + nombrePersona + " Edad: " + edad + " Estatura: " + estatura);        
    }
}
