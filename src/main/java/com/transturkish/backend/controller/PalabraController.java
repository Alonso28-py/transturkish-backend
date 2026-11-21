package com.transturkish.backend.controller;

import com.transturkish.backend.model.Palabra;
import com.transturkish.backend.repository.PalabraRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@RestController
@RequestMapping("/api/palabras")
public class PalabraController {

    private final PalabraRepository repository;

    public PalabraController(PalabraRepository repository) {
        this.repository = repository;
    }

    // Obtener todas las palabras guardadas
    @GetMapping
    public List<Palabra> obtenerPalabras() {
        return repository.findAll();
    }

    // Agregar una nueva palabra a la base de datos
    @PostMapping
    public Palabra crearPalabra(@RequestBody Palabra palabra) {
        return repository.save(palabra);
    }

    // Actualizar una palabra existente
    @PutMapping("/{id}")
    public ResponseEntity<Palabra> actualizarPalabra(
            @PathVariable Long id,
            @RequestBody Palabra datos) {

        Palabra palabra = repository.findById(id).orElse(null);

        // Comprobar si la palabra existe
        if (palabra == null) {
            return ResponseEntity.notFound().build();
        }

        // Actualizar sus datos
        palabra.setTurco(datos.getTurco());
        palabra.setEspanol(datos.getEspanol());

        // Guardar los cambios en la base de datos
        return ResponseEntity.ok(repository.save(palabra));
    }

    // Eliminar una palabra por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPalabra(
            @PathVariable Long id) {

        // Comprobar si la palabra existe
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        // Eliminar la palabra de la base de datos
        repository.deleteById(id);

        // Confirmar que fue eliminada
        return ResponseEntity.noContent().build();
    }


}
