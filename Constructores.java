/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarios;

import java.io.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author instalador
 */
public class Constructores implements Serializable {

    File fichero = null;
    File directorio = null;
    FileOutputStream archivo1 = null;
    FileOutputStream archivo2 = null;
    FileInputStream flujoEntrada = null;
    DataInputStream entrada = null;
    FileOutputStream fout = null;
    DataOutputStream dout = null;
    FileInputStream fIn = null;
    DataInputStream in = null;
    DataOutputStream dato1 = null;
    DataOutputStream dato2 = null;
    DataInputStream leo = null;
    FileOutputStream ffout = null;

    final String direccion = "C:\\Users\\Instalador\\Desktop";
    //static final String direccion = "C:\\Users\\Victor\\Desktop";
    String nombreFichero = "datos.ods";
    String nombreFichero2;

    /**
     * Este constructor no recibe parametros
     */
    public Constructores() {
        //this("Peeeee");
        fichero = new File(direccion, nombreFichero);
        crearDirectorio();
        crearFichero();
    }

    /**
     * Este constructor establece el nombre del fichero que se le pasa por
     * parametro
     *
     * @param nom parametro de tipo String que contiene el nombre del fichero
     */
    public Constructores(String nom) {
        this.nombreFichero2 = nom;        
        fichero = new File(direccion, nombreFichero2);
        crearFichero();
        crearDirectorio();
    }

    /**
     * Crea el fichero
     */
    public void crearFichero() {
        try {
            fichero.createNewFile();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * Crea el directorio
     */
    public void crearDirectorio() {
        directorio = new File(direccion, "\\Binarios");
        directorio.mkdir();
    }

    /**
     * Este metodo crea un flujo de salida para guardar el numero entero
     * introducido por consola.
     */
    public void crearEnteros() {
        try {
            archivo1 = new FileOutputStream(direccion + "\\Numeros.dat", true);
            archivo2 = new FileOutputStream(direccion + "\\datos.ods", true);
            DataOutputStream dato1 = new DataOutputStream(archivo1);
            DataOutputStream dato2 = new DataOutputStream(archivo2);
            Scanner sca = new Scanner(System.in);

            System.out.println("Introduce un numero:");
            int numero = sca.nextInt();

            while (numero != -1) {
                dato1.writeInt(numero);
                dato2.writeInt(numero);
                System.out.println("Introduce un numero:");
                numero = sca.nextInt();
            }
            dato1.close();
            dato2.close();

        } catch (IOException e) {
            e.getMessage();
        }
    }

    /**
     * Este metodo va a leer el fichero creado anteriormente y lo muestra en
     * consola.
     */
    public void leerEnteros() {
        try {
            flujoEntrada = new FileInputStream(direccion + "\\Numeros.dat");
            leo = new DataInputStream(flujoEntrada);

            while (true) {
                System.out.println(leo.readInt());
            }

        } catch (EOFException e) {
        } catch (IOException ex) {
            Logger.getLogger(Constructores.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            leo.close();
        } catch (IOException ex) {
            Logger.getLogger(Constructores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Con este metodo creamos 3 personas y las guardamos en un fichero de
     * datos.
     */
    public void crearPersona() {
        Scanner sca = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println("Introduzca un nombre: ");
            String nombre = sca.next();
            System.out.println("Introduzca una edad: ");
            int edad = sca.nextInt();
            System.out.println("Introduzca una altura: ");
            double altura = sca.nextDouble();
            try {
                fout = new FileOutputStream(direccion + "\\Personas1.dat", true);
                dout = new DataOutputStream(fout);

                //Puedo guardar los datos en una sola linea       
                String persona = "Nombre: " + nombre + " Edad: " + edad + " Altura: " + altura;
                dout.writeUTF(persona);

                //Puedo guardar los datos de manera secuencial
                //dout.writeUTF(nombre);
                //dout.writeInt(edad);
                //dout.writeDouble(altura);
                dout.close();
                fout.close();
            } catch (Exception e) {
                System.out.println("No se pudo guardar las personas");
            }
        }
    }

    /**
     * Con este metodo leemos las personas creadas anteriormente
     */
    public void leerPersona() {
        try {
            fIn = new FileInputStream(direccion + "\\Personas1.dat");
            in = new DataInputStream(fIn);

            while (true) {
                System.out.println(in.readUTF());
            }
        } catch (EOFException e) {
        } catch (IOException ex) {
            try {
                in.close();
                fIn.close();
            } catch (IOException ex1) {
                Logger.getLogger(Constructores.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    /**
     * Con este metodo creamos una agenda con datos de personas
     */
    public void crearAgenda(String nombre, String apellido, int telefono) {

        try {
            ffout = new FileOutputStream(direccion + "\\Agenda.ods", true);
            dout = new DataOutputStream(ffout);

            //Los datos los puedo escribir en una sola lina
            //String agenda = "Nombre " + nombre + "   Apeellidos: " + apellido + "   Telefono: " + telefono;
            //dout.writeUTF(agenda); 
            //Tambien puedo escribir los datos de manera secuencial.
            dout.writeUTF(nombre);
            dout.writeUTF(apellido);
            dout.writeInt(telefono);

            dout.close();
            ffout.close();
        } catch (Exception e) {
            System.out.println("No se pudo guardar la agenda");
        }
    }

    /**
     * Con este metodo leemos la agenda con los datos de las personas
     */
    public void leerAgenda() {
        try {
            fIn = new FileInputStream(direccion + "\\Agenda.ods");
            in = new DataInputStream(fIn);

            while (true) {
                //Los datos los puedo leer en una sola lina
                String a = in.readUTF();
                String b = in.readUTF();
                long c = in.readInt();
                System.out.println("Nombre: " + a + " Apellido: " + b + " Telefono: " + c);

                //Tambien puedo leer los datos en varias linea       
                /* System.out.println(in.readUTF());
                System.out.println(in.readUTF());
                System.out.println(in.readInt());*/
            }
        } catch (EOFException e) {
            try {
                fIn.close();
                in.close();
            } catch (IOException ex1) {
                Logger.getLogger(Constructores.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (IOException ex) {
        }
    }
    
   public void crearAgendaUTF(String nombre, String apellido, int telefono) {

        try {
            ffout = new FileOutputStream(direccion + "\\AgendaUTF.ods", true);
            dout = new DataOutputStream(ffout);

            //Los datos los puedo escribir en una sola lina
            //String agenda = "Nombre " + nombre + "   Apeellidos: " + apellido + "   Telefono: " + telefono;
            //dout.writeUTF(agenda); 
            //Tambien puedo escribir los datos de manera secuencial.
            dout.writeUTF(nombre);
            dout.writeUTF(apellido);
            dout.writeUTF(String.valueOf(telefono));

            dout.close();
            ffout.close();
        } catch (Exception e) {
            System.out.println("No se pudo guardar la agenda");
        }
    }
    
    
}
