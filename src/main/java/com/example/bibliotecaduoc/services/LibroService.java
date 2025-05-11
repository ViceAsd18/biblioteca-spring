package com.example.bibliotecaduoc.services;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro añadirLibro(Libro libro){
        return libroRepository.guardarLibro(libro);
    }

    public Libro getLibroById(int id){
        return libroRepository.buscarLibroPorId(id);
    }

    public Libro actualizarLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String eliminarLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Producto Eliminado";
    }

    public int totalLibros(){
        return libroRepository.totalLibros();
    }

    public Libro obtenerLibroPorIsbn(String parIsbn ){
        return libroRepository.obtenerLibroPorIsbn(parIsbn);
    }

    public List<Libro> obtenerLibrosPorAnio(int anio){
        return libroRepository.obtenerLibrosPorAnio(anio);
    }

    public List<Libro> obtenerLibrosPorAutor(String parAutor){
        return libroRepository.obtenerLibrosPorAutor(parAutor);
    }

    public Libro obtenerLibroAntiguo(){
        return libroRepository.obtenerLibroAntiguo();
    }

    public Libro obtenerLibroNuevo(){
        return libroRepository.obtenerLibroNuevo();
    }

    public List<Libro> obtenerLibrosOrdenado(){
        return libroRepository.obtenerLibroOrdenados();
    }

}
