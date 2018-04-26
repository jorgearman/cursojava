/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.gm.peliculas.datos;

import co.com.gm.peliculas.domain.Pelicula;
import co.com.gm.peliculas.excepciones.AccesoDatosEx;
import co.com.gm.peliculas.excepciones.EscrituraDatosEx;
import java.util.List;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge.arbelaez
 */
public class AccesoDatosImpl implements AccesoDatos{ 
    
    private static boolean archivoCreado = false;

    @Override
    public boolean existe(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        
        List<Pelicula> peliculas = new ArrayList<>();
        
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            
            while (lectura != null){
                peliculas.add(new Pelicula(lectura)); 
                
                lectura = entrada.readLine();
            }            
            entrada.close();
                     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws AccesoDatosEx {
      
        
        try {
            File archivo = new File(nombreArchivo);        

            PrintWriter salida = new PrintWriter(new FileWriter(archivo,anexar));

            String contenido = pelicula.getNombre();            
            salida.println(contenido);            
            salida.close();
            
        } catch (IOException ex) {
           throw new EscrituraDatosEx("Error escribiendo el nombre de la pelicula:"+ex.getMessage());
        }   
       
    }

    @Override
    public String buscar(String nombreArchivo, String buscar) {
        File archivo = new File(nombreArchivo);        
        
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String lectura = entrada.readLine();
            
            while (lectura != null){
                
                if (lectura.equals(buscar)) {
                    return "La pelicula fuen encontrada";
                }
                
                lectura = entrada.readLine();
            }            
            entrada.close();
                     
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "No se encontro la pelicula buscada";
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx {
        
        if (archivoCreado) {
            
            System.out.println("El archivo ya fue creado");
            
        } else {
            
            File archivo = new File(nombreArchivo);            
            System.out.println("El archivo fue creado con exito");
                       
            try {
                PrintWriter salida = new PrintWriter(new FileWriter(archivo));
                archivoCreado = true;
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }

    @Override
    public void borrar(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
