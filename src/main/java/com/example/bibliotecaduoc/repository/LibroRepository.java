package com.example.bibliotecaduoc.repository;

import com.example.bibliotecaduoc.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibroRepository {

    //Arreglo que guardara todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroRepository() {
        listaLibros.add(new Libro(1, "9789569646638", "Fuego y Sangre", "Penguin Random House Grupo Editorial", 2018, "George R. R. Martin"));
        listaLibros.add(new Libro(2, "9789563494150", "Quique Hache: El Mall Embrujado y Otras Historias", "Sm Ediciones", 2014, "Sergio Gomez"));
        listaLibros.add(new Libro(3, "9781484256251", "Spring Boot Persistence Best Practices", "Apress", 2020, "Anghel Leonard"));
        listaLibros.add(new Libro(4, "9789566075752", "Harry Potter y la piedra filosofal", "Salamandra", 2024, "J. K. Rowling"));
        listaLibros.add(new Libro(5, "9780439139601", "Harry Potter y el prisionero de Azkaban", "Scholastic", 1999, "J. K. Rowling"));
        listaLibros.add(new Libro(6, "9780439136365", "Harry Potter y el cáliz de fuego", "Scholastic", 2000, "J. K. Rowling"));
        listaLibros.add(new Libro(7, "9780321127426", "Effective Java", "AddisonWesley", 2008, "Joshua Bloch"));
        listaLibros.add(new Libro(8, "9780134685991", "Clean Architecture", "Prenticel", 2017, "Robert C. Martin"));
        listaLibros.add(new Libro(9, "9780201633610", "Design Patterns", "AddisonWesley", 1994, "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides"));
        listaLibros.add(new Libro(10, "9780132350884", "Clean Code", "Prentice Hall", 2008, "Robert C. Martin"));

    }


    //Metodo que retornara todos los libros
    public List<Libro> obtenerLibros(){
        return this.listaLibros;
    }

    //Metodo para buscar el libro por id
    public Libro buscarLibroPorId(int id){
        for(Libro libro: listaLibros){
            if(libro.getId() == id){
                return libro;
            }
        }
        return null;
    }

    //Metodo que guarda el libro en el arreglo
    public Libro guardarLibro(Libro libro){
        listaLibros.add(libro);
        return libro;
    }

    //Metodo que actualiza el libro por ID
    public Libro actualizarLibro(Libro parLibro){

    int id = 0;
    int idPosicion = 0;

    for(int i = 0; i<listaLibros.size(); i++){
        if(listaLibros.get(i).getId() == parLibro.getId()){
            id = parLibro.getId();
            idPosicion = i;
        }
    }

    Libro libroActualizar = new Libro();
    libroActualizar.setId(id);
    libroActualizar.setTitulo(parLibro.getTitulo());
    libroActualizar.setAutor(parLibro.getAutor());
    libroActualizar.setFechaPublicacion(parLibro.getFechaPublicacion());
    libroActualizar.setEditorial(parLibro.getEditorial());
    libroActualizar.setIsbn(parLibro.getIsbn());

    listaLibros.set(idPosicion, libroActualizar);
    return libroActualizar;
    }

    public void eliminarLibro(int id){
        Libro libro = buscarLibroPorId(id);
        if(libro != null){
            listaLibros.remove(libro);
        }
    }

    public int totalLibros(){
        return listaLibros.size();
    }

    public Libro obtenerLibroPorIsbn(String parIsbn){
        for(Libro libro: listaLibros){
            if(libro.getIsbn().equals(parIsbn)){
                return libro;
            }
        }
        return null;
    }

    public List<Libro> obtenerLibrosPorAnio(int anio){
        List<Libro> librosEncontrados = new ArrayList<>();
        for(Libro libro: listaLibros){
            if(libro.getFechaPublicacion() == anio){
                librosEncontrados.add(libro);
            }
        }return  librosEncontrados;
    }

    public List<Libro> obtenerLibrosPorAutor(String autor){
        List<Libro> librosEncontrados = new ArrayList<>();
        for(Libro libro: listaLibros){
            if(libro.getAutor().equals(autor)){
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public Libro obtenerLibroAntiguo(){
        Libro libroEncontrado = listaLibros.get(0);

        for(Libro libro: listaLibros){
            if(libro.getFechaPublicacion() < libroEncontrado.getFechaPublicacion()){
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    public Libro obtenerLibroNuevo(){
        Libro libroEncontrado = listaLibros.get(0);

        for(Libro libro: listaLibros){
            if(libro.getFechaPublicacion() > libroEncontrado.getFechaPublicacion()){
                libroEncontrado = libro;
            }
        }
        return libroEncontrado;
    }

    public List<Libro> obtenerLibroOrdenados(){
        List<Libro> librosOrdenados = new ArrayList<>(listaLibros);

        for(int i = 0; i < librosOrdenados.size() -1; i++){
            for(int j = i+1; j < librosOrdenados.size(); j++){
                if(librosOrdenados.get(i).getFechaPublicacion() > librosOrdenados.get(j).getFechaPublicacion()){

                    //Intercambiamos los libros en caso de que libro de la posicion I fue publicado despues que el de la posicion j
                    Libro temporal = librosOrdenados.get(i);
                    librosOrdenados.set(i, librosOrdenados.get(j));
                    librosOrdenados.set(j, temporal);
                }
            }
        }
        return librosOrdenados;
    }

}
