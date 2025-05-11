package com.example.bibliotecaduoc.controller;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public List<Libro> getLibros() {
        return libroService.getLibros();
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {
        return libroService.añadirLibro(libro);
    }

    @GetMapping("{id}")
    public Libro buscarLibro(@PathVariable int id) {
        return  libroService.getLibroById(id);
    }

    @PutMapping("{id}")
    public Libro modificarLibro(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.actualizarLibro(libro);
    }

    @DeleteMapping("{id}")
    public String eliminarLibro(@PathVariable int id) {
        return libroService.eliminarLibro(id);
    }

    @GetMapping("/total")
    public int totalLibros(){
        return libroService.totalLibros();
    }

    @GetMapping("/isbn/{isbn}")
    public Libro getlibroPorISBN(@PathVariable String isbn){
        return libroService.obtenerLibroPorIsbn(isbn);
    }

}
