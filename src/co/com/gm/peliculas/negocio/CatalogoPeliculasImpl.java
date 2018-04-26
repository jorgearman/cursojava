/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.peliculas.negocio;

import co.com.gm.peliculas.datos.AccesoDatos;
import co.com.gm.peliculas.datos.AccesoDatosImpl;
import co.com.gm.peliculas.domain.Pelicula;
import co.com.gm.peliculas.excepciones.AccesoDatosEx;
import java.util.List;


/**
 *
 * @author jorge.arbelaez
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        datos = new AccesoDatosImpl();
    }
    
        
    @Override
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo) {
        
        Pelicula pelicula = new Pelicula(nombrePelicula);        
              
        try {
            datos.escribir(pelicula, nombreArchivo, true);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
        }        
        
    }

    @Override
    public void listarPeliculas(String nombreArchivo)   {
        
        try {
                  
            List<Pelicula> peliculas = datos.listar(nombreArchivo);

            System.out.println("Listado de peliculas");
            for (Pelicula pelicula : peliculas) {
                System.out.println("-"+pelicula.getNombre());
            }
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void buscarPelicula(String nombreArchivo, String buscar) {
           
        try {
            System.out.println(datos.buscar(nombreArchivo, buscar));
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
        }
        
    }

    @Override
    public void iniciarArchivo(String nombreArchivo)  {
        
        try {
            datos.crear(nombreArchivo);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
        }
    }   
   
    
}
