/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.peliculas.datos;

import co.com.gm.peliculas.domain.Pelicula;
import co.com.gm.peliculas.excepciones.AccesoDatosEx;
import java.util.List;

/**
 *
 * @author jorge.arbelaez
 */
public interface AccesoDatos {
    
    public boolean existe (String nombreArchivo) throws AccesoDatosEx;
    public List<Pelicula> listar(String nombre) throws AccesoDatosEx;
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx;
    public String buscar(String nombreArchivo, String buscar) throws AccesoDatosEx;
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws AccesoDatosEx;   
    
    
    
}
