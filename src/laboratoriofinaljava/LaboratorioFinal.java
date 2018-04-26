/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratoriofinaljava;
import co.com.gm.peliculas.excepciones.AccesoDatosEx;
import co.com.gm.peliculas.negocio.CatalogoPeliculas;
import co.com.gm.peliculas.negocio.CatalogoPeliculasImpl;
import java.util.Scanner;
/**
 *
 * @author jorge.arbelaez
 */
public class LaboratorioFinal {
    
    private final static String nombreArchivo = "C:\\ArchivoJava\\peliculas.txt";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AccesoDatosEx {
        int opcion = 0 ;
              
        System.out.println("Elije una Opción:");
        System.out.println("1.- Iniciar Pelicula");
        System.out.println("2.- Agregar Pelicula");
        System.out.println("3.- Listar Pelicula");
        System.out.println("4.- Buscar Pelicula");
        System.out.println("0.- Salir");
        do {          
            Scanner scan = new Scanner(System.in);
            opcion = scan.nextInt();
            /*opcion = 3;*/
            ejecutar(opcion);
            
            System.out.println("Elije una Opción:");

            /*opcion = 0;*/
        } while (opcion != 0);
        
        System.out.println("Fin de la aplicación");
    }
    
    public static void ejecutar(int opcion) throws AccesoDatosEx{
        
        CatalogoPeliculas catpeli = new CatalogoPeliculasImpl();
        Scanner scan = new Scanner(System.in);
        
        switch(opcion){
                case 1:
                    catpeli.iniciarArchivo(nombreArchivo);  
                        break;
                case 2:
                    System.out.println("Ingrese la pelicula:");
                    
                    String nombrePelicula = scan.nextLine();
                    /*String nombrePelicula = "Vida infinita";*/
                    
                    catpeli.agregarPeliculas(nombrePelicula, nombreArchivo);
                    
                    break;
                case 3:
                        catpeli.listarPeliculas(nombreArchivo);
                    break;
                case 4:
                    System.out.println("Ingrese la pelicula a buscar:");                    
                    String nombrePeliculaBuscada = scan.nextLine();
                    
                    catpeli.buscarPelicula(nombreArchivo, nombrePeliculaBuscada);
                    
                    break;
            }        
    }
    
}
