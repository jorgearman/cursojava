/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.peliculas.negocio;
import co.com.gm.peliculas.excepciones.*;

/**
 *
 * @author jorge.arbelaez
 */
public interface CatalogoPeliculas {
    
    public void agregarPeliculas(String nombrePelicula, String nombreArchivo);
    public void listarPeliculas(String nombreArchivo);
    public void buscarPelicula(String nombreArchivo, String buscar) ; 
    public void iniciarArchivo(String nombreArchivo);
}
